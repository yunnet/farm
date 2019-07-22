package com.farm.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.farm.auth.server.interceptor.ServiceAuthRestInterceptor;
import com.farm.auth.server.interceptor.UserAuthRestInterceptor;
import com.farm.common.handler.GlobalExceptionHandler;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: WebConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:18:10 <br />
 * 最后修改: 2018-09-04 10:18:10 <br />
 * 修改历史: <br />
 */
@Configuration("admimWebConfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {
	
	@Bean
	public GlobalExceptionHandler getGlobalExceptionHandler() {
		return new GlobalExceptionHandler();
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getServiceAuthRestInterceptor()).addPathPatterns("/service/**");
        registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/service/**");
    }

    @Bean
    public ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
        return new ServiceAuthRestInterceptor();
    }

    @Bean
    public UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }
}