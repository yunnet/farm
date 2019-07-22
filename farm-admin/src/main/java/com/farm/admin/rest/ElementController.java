package com.farm.admin.rest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.admin.biz.ElementBiz;
import com.farm.admin.biz.UserBiz;
import com.farm.admin.entity.Element;
import com.farm.common.msg.ObjectRestResponse;
import com.farm.common.msg.TableResultResponse;
import com.farm.common.rest.BaseController;

import tk.mybatis.mapper.entity.Example;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: ElementController.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 15:14:55 <br />
 * 最后修改: 2018-09-05 15:14:55 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("element")
public class ElementController extends BaseController<ElementBiz, Element> {
	@Autowired
	private UserBiz userBiz;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResultResponse<Element> page(@RequestParam(defaultValue = "10") int limit, 
			                                 @RequestParam(defaultValue = "1") int offset, 
			                                 @RequestParam String name, 
			                                 @RequestParam(defaultValue = "0") int menuId
			                                 ) {
		Example example = new Example(Element.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("menuId", menuId);
		if (StringUtils.isNotBlank(name)) {
			criteria.andLike("name", "%" + name + "%");
		}

		List<Element> list = baseBiz.selectByExample(example);
		return new TableResultResponse<Element>(list.size(), list);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ObjectRestResponse<Element> getAuthorityElement(String menuId) {
		int userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
		
		List<Element> list = baseBiz.getAuthorityElementByUserId(userId + "", menuId);
		return new ObjectRestResponse<List<Element>>().data(list);
	}

	/**
	 * 获取用户目录
	 * @return
	 */
	@RequestMapping(value = "/user/menu", method = RequestMethod.GET)
	public ObjectRestResponse<Element> getAuthorityElement() {
		int userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
		
		List<Element> list = baseBiz.getAuthorityElementByUserId("" + userId);
		return new ObjectRestResponse<List<Element>>().data(list);
	}
}