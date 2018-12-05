package com.farm.blog.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import tk.mybatis.spring.annotation.MapperScan;


/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-30 09:03:22 <br />
 * 最后修改: 2018-10-30 09:03:22 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
@MapperScan("com.farm.blog.admin.mapper")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
