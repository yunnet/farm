package com.farm.admin.mapper;

import org.apache.ibatis.annotations.Param;

import com.farm.admin.entity.Group;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: GroupMapper.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 09:57:33 <br />
 * 最后修改: 2018-09-05 09:57:33 <br />
 * 修改历史: <br />
 */
public interface GroupMapper extends Mapper<Group> {
	public void deleteGroupMembersById (@Param("groupId") int groupId);
	
    public void deleteGroupLeadersById (@Param("groupId") int groupId);
    
    public void insertGroupMembersById (@Param("groupId") int groupId, @Param("userId") int userId);
    
    public void insertGroupLeadersById (@Param("groupId") int groupId, @Param("userId") int userId);
}
