package com.farm.auth.client.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: AutoConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:10:05 <br />
 * 最后修改: 2018-09-04 17:10:05 <br />
 * 修改历史: <br />
 */
@Configurable
@ComponentScan({"com.farm.auth.client"})
public class AutoConfiguration {
	
	@Bean
	public ServiceAuthConfig getServiceAuthConfig() {
		return new ServiceAuthConfig();
	}
	
	@Bean
	public UserAuthConfig getUserAuthConfig() {
		return new UserAuthConfig();
	}
}