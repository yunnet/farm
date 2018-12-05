package com.farm.auth.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.farm.auth.server.configuration.ClientConfiguration;
import com.farm.auth.server.service.AuthClientService;
import com.farm.auth.server.util.client.ClientTokenUtil;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.common.exception.auth.ClientForbiddenException;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ServiceAuthRestInterceptor.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 16:20:57 <br />
 * 最后修改: 2018-09-04 16:20:57 <br />
 * 修改历史: <br />
 */
@SuppressWarnings("all")
public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {
	@Autowired
    private ClientTokenUtil clientTokenUtil;
    
    @Autowired
    private AuthClientService authClientService;
    
    @Autowired
    private ClientConfiguration clientConfiguration;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(clientConfiguration.getClientTokenHeader());
        IJWTInfo infoFromToken = clientTokenUtil.getInfoFromToken(token);
        String uniqueName = infoFromToken.getUniqueName();
        
        for(String client: authClientService.getAllowedClient(clientConfiguration.getClientId())){
            if(client.equals(uniqueName)){
                return super.preHandle(request, response, handler);
            }
        }
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}