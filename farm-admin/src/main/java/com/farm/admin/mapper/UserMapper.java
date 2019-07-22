package com.farm.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.farm.admin.entity.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: UserMapper.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 10:00:29 <br />
 * 最后修改: 2018-09-05 10:00:29 <br />
 * 修改历史: <br />
 */
public interface UserMapper extends Mapper<User>{
	
	public List<User> selectMemberByGroupId(@Param("groupId") int groupId);
	
    public List<User> selectLeaderByGroupId(@Param("groupId") int groupId);
}