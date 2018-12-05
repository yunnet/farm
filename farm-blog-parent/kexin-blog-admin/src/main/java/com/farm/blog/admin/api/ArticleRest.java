package com.farm.blog.admin.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.blog.admin.biz.ArticleBiz;
import com.farm.blog.admin.entity.Article;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ArticleRest.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-29 15:43:27 <br />
 * 最后修改: 2018-10-29 15:43:27 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("api/article")
public class ArticleRest {
	@Autowired
	private ArticleBiz articleBiz;
	
	@GetMapping(value = "/{id}")
	public Object get(@PathVariable int id, String callback) {
		Article article = articleBiz.selectById(id);
		return article;
	}
	
	@GetMapping(value = "/page", produces = "application/json;charset=UTF-8")
	public Object get(@RequestParam(defaultValue="0") Integer pageIndex, @RequestParam(defaultValue="0") Integer pageSize, String callback) {
		Page<Article> obj = PageHelper.startPage(pageIndex, pageSize);
		List<Article> listArray = articleBiz.selectListAll();
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rel", true);
		resultMap.put("msg", "获取成功");
		
		resultMap.put("list", listArray);
		resultMap.put("count", obj.getTotal());
		
		return resultMap;
	}
}