package com.farm.gateway.filter;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSONObject;
import com.farm.api.vo.authority.PermissionInfo;
import com.farm.api.vo.log.LogInfo;
import com.farm.auth.client.configuration.ServiceAuthConfig;
import com.farm.auth.client.configuration.UserAuthConfig;
import com.farm.auth.client.jwt.ServiceAuthUtil;
import com.farm.auth.client.jwt.UserAuthUtil;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.common.context.BaseContextHandler;
import com.farm.common.msg.BaseResponse;
import com.farm.common.msg.auth.TokenForbiddenResponse;
import com.farm.gateway.feign.ILogService;
import com.farm.gateway.feign.IUserService;
import com.farm.gateway.utils.DBLog;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: AccessGatewayFilter.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 10:36:05 <br />
 * 最后修改: 2018-09-12 10:36:05 <br />
 * 修改历史: <br />
 */
@Configuration
@Slf4j
public class AccessGatewayFilter implements GlobalFilter{
	private static final String GATE_WAY_PREFIX = "/api";
	
	@Autowired
	@Lazy
	private IUserService userService;
	
	@Autowired
	@Lazy
	private ILogService logService;
	
	@Value("${gate.ignore.startWith}")
	private String startWith;
	
	@Autowired
	private ServiceAuthConfig serviceAuthConfig;
	
	@Autowired
	private UserAuthConfig userAuthConfig;
	
	@Autowired
	private UserAuthUtil userAuthUtil;
	
	@Autowired
	private ServiceAuthUtil serviceAuthUtil;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("check token and user permission....");
		
		ServerHttpRequest request = exchange.getRequest();
		String requestUri = request.getPath().pathWithinApplication().value();
		LinkedHashSet<URI> requiredAttribute = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
		
		if(requiredAttribute != null) {
			for(URI uri : requiredAttribute) {
				if(uri.getPath().startsWith(GATE_WAY_PREFIX)) {
					requestUri = uri.getPath().substring(GATE_WAY_PREFIX.length());
				}
			}
		}
		
		BaseContextHandler.setToken(null);		
		ServerHttpRequest.Builder mutate = request.mutate();
		
		if(isStartWith(requestUri)) {
			ServerHttpRequest build = mutate.build();
			return chain.filter(exchange.mutate().request(build).build());
		}
		
		IJWTInfo user = null;
		try {
			user = getJWTUser(request, mutate);
		} catch (Exception e) {
			log.error("用户Token过期异常", e);
            return getVoidMono(exchange, new TokenForbiddenResponse("User Token Forbidden or Expired!"));
		}
		
		List<PermissionInfo> permissionInfos = userService.getAllPermissionInfo();
		final String method = request.getMethod().toString();
		
		//判断资源是否启用权限约束
		Stream<PermissionInfo> stream = getPermissionIfs(requestUri, method, permissionInfos);
		List<PermissionInfo> result = stream.collect(Collectors.toList());
		PermissionInfo[] permissions = result.toArray(new PermissionInfo[]{});
		if(permissions.length > 0) {
			if(checkUserPermission(permissions, exchange, user)) {
				return getVoidMono(exchange, new TokenForbiddenResponse("User Forbidden! Does not has Permission!"));
			}
		}
		
		mutate.header(serviceAuthConfig.getTokenHeader(), serviceAuthUtil.getClientToken());
		ServerHttpRequest build = mutate.build();
		
		return chain.filter(exchange.mutate().request(build).build());
	}
	
	/**
	 * 判断资源是否启用权限约束
	 * @param permissions
	 * @param exchange
	 * @param user
	 * @return
	 */
	private boolean checkUserPermission(PermissionInfo[] permissions, ServerWebExchange exchange, IJWTInfo user) {
        List<PermissionInfo> permissionInfos = userService.getPermissionByUsername(user.getUniqueName());
        PermissionInfo current = null;
        for (PermissionInfo info : permissions) {
            boolean anyMatch = permissionInfos.parallelStream().anyMatch(new Predicate<PermissionInfo>() {
                @Override
                public boolean test(PermissionInfo permissionInfo) {
                    return permissionInfo.getCode().equals(info.getCode());
                }
            });
            
            if (anyMatch) {
                current = info;
                break;
            }
        }
        
        if (current == null) {
            return true;
        } else {
            if (!RequestMethod.GET.toString().equals(current.getMethod())) {
                setCurrentUserInfoAndLog(exchange, user, current);
            }
            return false;
        }
    }
	
	/**
	 * 
	 * @param exchange
	 * @param user
	 * @param pm
	 */
	private void setCurrentUserInfoAndLog(ServerWebExchange exchange, IJWTInfo user, PermissionInfo pm) {
        String host = exchange.getRequest().getRemoteAddress().toString();
        LogInfo logInfo = new LogInfo(pm.getMenu(), pm.getName(), pm.getUri(), new Date(), user.getId(), user.getName(), host);
        DBLog.getInstance().setLogService(logService).offerQueue(logInfo);
    }
	
	/**
     * 获取目标权限资源
     *
     * @param requestUri
     * @param method
     * @param serviceInfo
     * @return
     */
    private Stream<PermissionInfo> getPermissionIfs(final String requestUri, final String method, List<PermissionInfo> serviceInfo) {
        return serviceInfo.parallelStream().filter(new Predicate<PermissionInfo>() {
            @Override
            public boolean test(PermissionInfo permissionInfo) {
                String uri = permissionInfo.getUri();
                if (uri.indexOf("{") > 0) {
                    uri = uri.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
                }
                String regEx = "^" + uri + "$";
                return (Pattern.compile(regEx).matcher(requestUri).find()) && method.equals(permissionInfo.getMethod());
            }
        });
    }
	
    /**
     * URI是否以什么打头
     * @param requestUri
     * @return
     */
	private boolean isStartWith(String requestUri) {
		boolean flag = false;
        for (String s : this.startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
	}
	
	/**
     * 网关抛异常
     * @param body
     */
    @NotNull
    private Mono<Void> getVoidMono(ServerWebExchange exchange, BaseResponse body) {
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        return exchange.getResponse().writeWith(Flux.just(buffer));
    }
	
	/**
     * 返回session中的用户信息
     * @param request
     * @param ctx
     * @return
     */
    private IJWTInfo getJWTUser(ServerHttpRequest request, ServerHttpRequest.Builder ctx) throws Exception {
        List<String> strings = request.getHeaders().get(userAuthConfig.getTokenHeader());
        String userToken = null;
        if (null != strings) {
            userToken = strings.get(0);
        }
        
        if (StringUtils.isBlank(userToken)) {
            strings = request.getQueryParams().get("token");
            if (strings != null) {
                userToken = strings.get(0);
            }
        }
        
        ctx.header(userAuthConfig.getTokenHeader(), userToken);
        BaseContextHandler.setToken(userToken);
        return userAuthUtil.getInfoFromToken(userToken);
    }
}