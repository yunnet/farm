package com.farm.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.farm.auth.client.EnableAuthClient;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 10:20:48 <br />
 * 最后修改: 2018-09-12 10:20:48 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthClient
@EnableFeignClients({"com.farm.auth.client.feign", "com.farm.gateway.feign"})
public class App {
	private final static Logger logger = LoggerFactory.getLogger(App.class);
	
	@Bean
	public feign.Logger.Level feginLoggerLevel(){
		return feign.Logger.Level.FULL;
	}
	
	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
		//响应式web应用
		new SpringApplicationBuilder(App.class).web(WebApplicationType.REACTIVE).run(args);
		
		logger.info("farm-gateway start :::::: [ ok ]");
	}
}
