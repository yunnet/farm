package com.farm.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farm.auth.server.interceptor.ClientTokenInterceptor;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: FeignConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 11:57:04 <br />
 * 最后修改: 2018-09-04 11:57:04 <br />
 * 修改历史: <br />
 */
@Configuration
public class FeignConfiguration {
	
	@Bean
	public ClientTokenInterceptor getClientTokenInterceptor() {
		return new ClientTokenInterceptor();
	}
}