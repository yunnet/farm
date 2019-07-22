package com.farm.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-18 11:44:03 <br />
 * 最后修改: 2018-10-18 11:44:03 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
@EnableConfigServer
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
