package com.farm.common.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.common.biz.BaseBiz;
import com.farm.common.context.BaseContextHandler;
import com.farm.common.msg.ObjectRestResponse;
import com.farm.common.msg.TableResultResponse;
import com.farm.common.util.Query;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: BaseController.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-03 16:07:17 <br />
 * 最后修改: 2018-09-03 16:07:17 <br />
 * 修改历史: <br />
 */
public class BaseController<Biz extends BaseBiz, Entity> {
	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected Biz baseBiz;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ObjectRestResponse<Entity> add(@RequestBody Entity entity) {
		baseBiz.insertSelective(entity);
		return new ObjectRestResponse<Entity>();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ObjectRestResponse<Entity> get(@PathVariable int id) {
		ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
		Object o = baseBiz.selectById(id);
		entityObjectRestResponse.data((Entity) o);
		return entityObjectRestResponse;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ObjectRestResponse<Entity> update(@RequestBody Entity entity) {
		baseBiz.updateSelectiveById(entity);
		return new ObjectRestResponse<Entity>();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ObjectRestResponse<Entity> remove(@PathVariable int id) {
		baseBiz.deleteById(id);
		return new ObjectRestResponse<Entity>();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Entity> all() {
		return baseBiz.selectListAll();
	}

	/**
	 * 查询列表数据
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ResponseBody
	public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		return baseBiz.selectByQuery(query);
	}

	/**
	 * 获取用户名
	 * @return
	 */
	public String getCurrentUserName() {
		return BaseContextHandler.getUsername();
	}
}