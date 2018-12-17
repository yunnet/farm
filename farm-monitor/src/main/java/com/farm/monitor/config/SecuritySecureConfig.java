package com.farm.monitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: SecuritySecureConfig.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-12-07 14:37:26 <br />
 * 最后修改: 2018-12-07 14:37:26 <br />
 * 修改历史: <br />
 * https://www.jianshu.com/p/c54e2c24c6aa
 * 
 */
@Profile("secure")
@Configuration
@EnableWebSecurity
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter{
	
	private final String adminContextPath;
	
	/**
	 * 构造函数
	 * @param properties
	 */
	public SecuritySecureConfig(AdminServerProperties properties) {
		this.adminContextPath = properties.getContextPath();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
		handler.setTargetUrlParameter("redirectTo");
		
		http.authorizeRequests()
		.antMatchers(adminContextPath + "/assets/**").permitAll()
		.antMatchers(adminContextPath + "/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage(adminContextPath + "/login").successHandler(handler)
		.and()
		.logout().logoutUrl(adminContextPath + "/logout")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}

}