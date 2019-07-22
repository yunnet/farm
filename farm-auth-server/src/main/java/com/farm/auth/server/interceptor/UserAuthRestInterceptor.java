package com.farm.auth.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.farm.auth.server.configuration.UserConfiguration;
import com.farm.auth.server.util.user.JwtTokenUtil;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.common.context.BaseContextHandler;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: UserAuthRestInterceptor.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 16:23:48 <br />
 * 最后修改: 2018-09-04 16:23:48 <br />
 * 修改历史: <br />
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
    @Autowired
    private UserConfiguration userConfiguration;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(userConfiguration.getUserTokenHeader());
        
        IJWTInfo info = jwtTokenUtil.getInfoFromToken(token);
        BaseContextHandler.setUsername(info.getUniqueName());
        BaseContextHandler.setUserID(info.getId());
        BaseContextHandler.setName(info.getName());
        return super.preHandle(request, response, handler);
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}