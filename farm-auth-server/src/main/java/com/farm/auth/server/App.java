package com.farm.auth.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 09:21:07 <br />
 * 最后修改: 2018-09-04 09:21:07 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.farm.auth.server.mapper")
public class App {
	private final static Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		logger.info("auth-server start :::::: [ ok ]");
	}
}