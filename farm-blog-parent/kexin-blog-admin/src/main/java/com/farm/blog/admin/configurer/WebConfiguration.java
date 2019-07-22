package com.farm.blog.admin.configurer;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: WebConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-29 16:39:44 <br />
 * 最后修改: 2018-10-29 16:39:44 <br />
 * 修改历史: <br />
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	//解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600)
                ;
    }
    
    @Bean
    public CorsFilter corsFilter() {
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", addCorsConfig());
		return new CorsFilter(source);
    }

    private CorsConfiguration addCorsConfig() {
    	CorsConfiguration corsConfiguration = new CorsConfiguration();
    	List<String> list = Arrays.asList("*");
    	corsConfiguration.setAllowedOrigins(list);
    	
    	//请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
    	corsConfiguration.addAllowedOrigin("*"); 
    	corsConfiguration.addAllowedHeader("*"); 
    	corsConfiguration.addAllowedMethod("*"); 
    	return corsConfiguration;
    }
}