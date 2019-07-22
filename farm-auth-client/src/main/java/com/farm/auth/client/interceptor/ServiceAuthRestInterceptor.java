package com.farm.auth.client.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.farm.auth.client.annotation.IgnoreClientToken;
import com.farm.auth.client.configuration.ServiceAuthConfig;
import com.farm.auth.client.jwt.ServiceAuthUtil;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.common.exception.auth.ClientForbiddenException;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: ServiceAuthRestInterceptor.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-04 18:08:30 <br />
 * 最后修改: 2018-09-04 18:08:30 <br />
 * 修改历史: <br />
 */
@SuppressWarnings("all")
public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private ServiceAuthUtil serviceAuthUtil;

	@Autowired
	private ServiceAuthConfig serviceAuthConfig;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		// 配置该注解，说明不进行服务拦截
		IgnoreClientToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreClientToken.class);
		if (annotation == null) {
			annotation = handlerMethod.getMethodAnnotation(IgnoreClientToken.class);
		}

		if (annotation != null) {
			return super.preHandle(request, response, handler);
		}

		String token = request.getHeader(serviceAuthConfig.getTokenHeader());
		IJWTInfo infoFromToken = serviceAuthUtil.getInfoFromToken(token);
		
		//获取用户名
		String uniqueName = infoFromToken.getUniqueName();
		for (String client : serviceAuthUtil.getAllowedClient()) {
			if (client.equals(uniqueName)) {
				return super.preHandle(request, response, handler);
			}
		}
		throw new ClientForbiddenException("Client is Forbidden!");
	}
}