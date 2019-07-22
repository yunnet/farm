package com.farm.blog.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-30 11:40:56 <br />
 * 最后修改: 2018-10-30 11:40:56 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
