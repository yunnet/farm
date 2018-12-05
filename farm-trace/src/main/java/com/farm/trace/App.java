package com.farm.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: App.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-17 15:56:26 <br />
 * 最后修改: 2018-09-17 15:56:26 <br />
 * 修改历史: <br />
 */
@SpringBootApplication
//@EnableEurekaClient
@zipkin2.server.internal.EnableZipkinServer

public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
