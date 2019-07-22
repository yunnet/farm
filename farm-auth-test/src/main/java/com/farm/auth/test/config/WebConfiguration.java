package com.farm.auth.test.config;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.farm.auth.client.interceptor.ServiceAuthRestInterceptor;
import com.farm.auth.client.interceptor.UserAuthRestInterceptor;
import com.farm.common.handler.GlobalExceptionHandler;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: WebConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-11 09:23:37 <br />
 * 最后修改: 2018-09-11 09:23:37 <br />
 * 修改历史: <br />
 */
@Configuration("admimWebConfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {
	 @Bean
	    GlobalExceptionHandler getGlobalExceptionHandler() {
	        return new GlobalExceptionHandler();
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(getServiceAuthRestInterceptor()).
	                addPathPatterns(getIncludePathPatterns()).addPathPatterns("/api/user/validate");
	        registry.addInterceptor(getUserAuthRestInterceptor()).
	                addPathPatterns(getIncludePathPatterns());
	    }

	    @Bean
	    ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
	        return new ServiceAuthRestInterceptor();
	    }

	    @Bean
	    UserAuthRestInterceptor getUserAuthRestInterceptor() {
	        return new UserAuthRestInterceptor();
	    }

	    /**
	     * 需要用户和服务认证判断的路径
	     * @return
	     */
	    private ArrayList<String> getIncludePathPatterns() {
	        ArrayList<String> list = new ArrayList<>();
	        String[] urls = {
	                "/element/**",
	                "/gateLog/**",
	                "/group/**",
	                "/groupType/**",
	                "/menu/**",
	                "/user/**",
	                "/api/permissions",
	                "/api/user/un/**"
	        };
	        Collections.addAll(list, urls);
	        return list;
	    }

}
