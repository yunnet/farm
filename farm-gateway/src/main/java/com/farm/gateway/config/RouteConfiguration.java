package com.farm.gateway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: RouteConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 10:22:39 <br />
 * 最后修改: 2018-09-12 10:22:39 <br />
 * 修改历史: <br />
 */
@Configuration
public class RouteConfiguration {
	
	@Bean
	public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient client, DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(client, properties);
	}
}