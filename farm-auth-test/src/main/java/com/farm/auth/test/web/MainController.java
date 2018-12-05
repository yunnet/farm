package com.farm.auth.test.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: MainController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-10 09:32:51 <br />
 * 最后修改: 2018-09-10 09:32:51 <br />
 * 修改历史: <br />
 */
@RestController
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "hello world!";
	}
}