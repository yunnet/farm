package com.farm.auth.client.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.farm.auth.client.annotation.IgnoreUserToken;
import com.farm.auth.client.configuration.UserAuthConfig;
import com.farm.auth.client.jwt.UserAuthUtil;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.common.context.BaseContextHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: UserAuthRestInterceptor.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 18:08:44 <br />
 * 最后修改: 2018-09-04 18:08:44 <br />
 * 修改历史: <br />
 */
@Slf4j
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter{
	@Autowired
    private UserAuthUtil userAuthUtil;

    @Autowired
    private UserAuthConfig userAuthConfig;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        
        // 配置该注解，说明不进行用户拦截
        IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
        }
        
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }
        
        String token = request.getHeader(userAuthConfig.getTokenHeader());
        log.info("preHandle: token={}", token);
        
        if (StringUtils.isEmpty(token)) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(userAuthConfig.getTokenHeader())) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        
        IJWTInfo info = userAuthUtil.getInfoFromToken(token);
        
        BaseContextHandler.setUsername(info.getUniqueName());
        BaseContextHandler.setName(info.getName());
        BaseContextHandler.setUserID(info.getId());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}