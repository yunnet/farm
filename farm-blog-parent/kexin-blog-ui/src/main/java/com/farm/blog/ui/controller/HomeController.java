package com.farm.blog.ui.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: HomeController.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-10-30 11:38:43 <br />
 * 最后修改: 2018-10-30 11:38:43 <br />
 * 修改历史: <br />
 */
@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/article")
	public String article() {
		return "article";
	}

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable String id, Map<String, Object> map) {
		map.put("articleId", id);
		return "detail";
	}

	@RequestMapping("/resource")
	public String resource() {
		return "resource";
	}

	@RequestMapping("/timeline")
	public String timeline() {
		return "timeline";
	}

}
