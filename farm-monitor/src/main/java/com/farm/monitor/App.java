package com.farm.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-17 12:30:00 <br />
 * 最后修改: 2018-09-17 12:30:00 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
@EnableAutoConfiguration
public class App {
	private final static Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		logger.info("farm-monitor start :::::: [ ok ]");
	}
}