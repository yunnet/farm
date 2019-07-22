package com.farm.monitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: SecurityPermitAllConfig.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-12-14 14:34:44 <br />
 * 最后修改: 2018-12-14 14:34:44 <br />
 * 修改历史: <br />
 */
@Profile("insecure")
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.headers().frameOptions().disable();
		
		http.authorizeRequests()
		.anyRequest()
		.permitAll()
		.and()
		.csrf()
		.disable();
		
//		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//		.ignoringAntMatchers(adminContextPath + "/instances", adminContextPath + "/actuator/**");
	}
}
