package com.farm.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.farm.admin.entity.Element;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: ElementMapper.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 09:39:05 <br />
 * 最后修改: 2018-09-05 09:39:05 <br />
 * 修改历史: <br />
 */
public interface ElementMapper extends Mapper<Element> {
	public List<Element> selectAuthorityElementByUserId(@Param("userId") String userId);

	public List<Element> selectAuthorityMenuElementByUserId(@Param("userId") String userId, @Param("menuId") String menuId);

	public List<Element> selectAuthorityElementByClientId(@Param("clientId") String clientId);

	public List<Element> selectAllElementPermissions();
}