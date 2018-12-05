package com.farm.blog.admin.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.blog.admin.biz.ArticleBiz;
import com.farm.blog.admin.entity.Article;
import com.github.pagehelper.PageHelper;
import com.farm.common.msg.TableResultResponse;
import com.farm.common.rest.BaseController;

import tk.mybatis.mapper.entity.Example;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ArticleController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-29 16:43:27 <br />
 * 最后修改: 2018-10-29 16:43:27 <br />
 * 修改历史: <br />
 */
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController<ArticleBiz, Article> {
	
	@RequestMapping(value = "/pages", method = RequestMethod.GET)
	@ResponseBody
	public TableResultResponse<Article> page(@RequestParam(defaultValue="0") Integer limit, @RequestParam(defaultValue="0") Integer offset, String title){
		Example example = new Example(Article.class);
		if(StringUtils.isNotBlank(title))
			example.createCriteria().andLike("title", "%" + title + "%");
		
		int count = baseBiz.selectCountByExample(example);
		PageHelper.startPage(offset, limit);
		return new TableResultResponse<Article>(count, baseBiz.selectByExample(example));
	}
}