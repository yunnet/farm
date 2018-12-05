package com.farm.admin.mapper;

import org.apache.ibatis.annotations.Param;

import com.farm.admin.entity.ResourceAuthority;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ResourceAuthorityMapper.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 09:59:59 <br />
 * 最后修改: 2018-09-05 09:59:59 <br />
 * 修改历史: <br />
 */
public interface ResourceAuthorityMapper extends Mapper<ResourceAuthority> {
	
	public void deleteByAuthorityIdAndResourceType(@Param("authorityId")String authorityId, @Param("resourceType") String resourceType);
}