package com.farm.admin.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.admin.entity.Element;
import com.farm.admin.mapper.ElementMapper;
import com.farm.cache.annotation.Cache;
import com.farm.cache.annotation.CacheClear;
import com.farm.common.biz.BaseBiz;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: ElementBiz.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 10:01:54 <br />
 * 最后修改: 2018-09-05 10:01:54 <br />
 * 修改历史: <br />
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ElementBiz extends BaseBiz<ElementMapper, Element> {

	@Cache(key = "permission:ele:u{1}")
	public List<Element> getAuthorityElementByUserId(String userId) {
		return mapper.selectAuthorityElementByUserId(userId);
	}

	public List<Element> getAuthorityElementByUserId(String userId, String menuId) {
		return mapper.selectAuthorityMenuElementByUserId(userId, menuId);
	}

	@Cache(key = "permission:ele")
	public List<Element> getAllElementPermissions() {
		return mapper.selectAllElementPermissions();
	}

	@Override
	@CacheClear(keys = { "permission:ele", "permission" })
	public void insertSelective(Element entity) {
		super.insertSelective(entity);
	}

	@Override
	@CacheClear(keys = { "permission:ele", "permission" })
	public void updateSelectiveById(Element entity) {
		super.updateSelectiveById(entity);
	}
}