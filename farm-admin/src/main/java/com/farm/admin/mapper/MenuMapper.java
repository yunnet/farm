package com.farm.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.farm.admin.entity.Menu;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: MenuMapper.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 09:58:52 <br />
 * 最后修改: 2018-09-05 09:58:52 <br />
 * 修改历史: <br />
 */
public interface MenuMapper extends Mapper<Menu>{
	
	public List<Menu> selectMenuByAuthorityId(@Param("authorityId") String authorityId, @Param("authorityType") String authorityType);

    /**
     * 根据用户和组的权限关系查找用户可访问菜单
     * @param userId
     * @return
     */
    public List<Menu> selectAuthorityMenuByUserId (@Param("userId") int userId);

    /**
     * 根据用户和组的权限关系查找用户可访问的系统
     * @param userId
     * @return
     */
    public List<Menu> selectAuthoritySystemByUserId (@Param("userId") int userId);

}