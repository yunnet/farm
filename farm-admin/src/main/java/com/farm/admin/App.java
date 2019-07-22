package com.farm.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.farm.auth.client.EnableAuthClient;
import com.farm.cache.EnableCache;
import com.spring4all.swagger.EnableSwagger2Doc;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 09:17:20 <br />
 * 最后修改: 2018-09-05 09:17:20 <br />
 * 修改历史: <br />
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"com.farm.auth.client.feign"})
@EnableScheduling
@EnableAuthClient
@EnableCache
@EnableTransactionManagement
@MapperScan("com.farm.admin.mapper")
@EnableSwagger2Doc
public class App {
	private final static Logger logger = LoggerFactory.getLogger(App.class);
	
	@Bean
	public feign.Logger.Level feginLoggerLevel(){
		return feign.Logger.Level.FULL;
	}
	
	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
		new SpringApplicationBuilder(App.class).web(WebApplicationType.SERVLET).run(args);
		logger.info("farm-admin start :::::: [ ok ]");
	}
}
