package com.farm.auth.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.farm.auth.client.EnableAuthClient;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-10 10:40:39 <br />
 * 最后修改: 2018-09-10 10:40:39 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
@EnableFeignClients({"com.farm.auth.client.feign"})
@EnableAuthClient
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}	
}