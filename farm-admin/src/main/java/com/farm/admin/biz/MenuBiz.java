package com.farm.admin.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.admin.constant.AdminCommonConstant;
import com.farm.admin.entity.Menu;
import com.farm.admin.mapper.MenuMapper;
import com.farm.cache.annotation.Cache;
import com.farm.cache.annotation.CacheClear;
import com.farm.common.biz.BaseBiz;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: MenuBiz.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 15:19:45 <br />
 * 最后修改: 2018-09-05 15:19:45 <br />
 * 修改历史: <br />
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuBiz extends BaseBiz<MenuMapper, Menu> {
	@Override
	@Cache(key = "permission:menu")
	public List<Menu> selectListAll() {
		return super.selectListAll();
	}

	@Override
	@CacheClear(keys = { "permission:menu", "permission" })
	public void insertSelective(Menu entity) {
		if (AdminCommonConstant.ROOT == entity.getParentId()) {
			entity.setPath("/" + entity.getCode());
		} else {
			Menu parent = this.selectById(entity.getParentId());
			entity.setPath(parent.getPath() + "/" + entity.getCode());
		}
		super.insertSelective(entity);
	}

	@Override
	@CacheClear(keys = { "permission:menu", "permission" })
	public void updateById(Menu entity) {
		if (AdminCommonConstant.ROOT == entity.getParentId()) {
			entity.setPath("/" + entity.getCode());
		} else {
			Menu parent = this.selectById(entity.getParentId());
			entity.setPath(parent.getPath() + "/" + entity.getCode());
		}
		super.updateById(entity);
	}

	@Override
	@CacheClear(keys = { "permission:menu", "permission" })
	public void updateSelectiveById(Menu entity) {
		super.updateSelectiveById(entity);
	}

	/**
	 * 获取用户可以访问的菜单
	 *
	 * @param id
	 * @return
	 */
	@Cache(key = "permission:menu:u{1}")
	public List<Menu> getUserAuthorityMenuByUserId(int id) {
		return mapper.selectAuthorityMenuByUserId(id);
	}

	/**
	 * 根据用户获取可以访问的系统
	 *
	 * @param id
	 * @return
	 */
	public List<Menu> getUserAuthoritySystemByUserId(int id) {
		return mapper.selectAuthoritySystemByUserId(id);
	}
}