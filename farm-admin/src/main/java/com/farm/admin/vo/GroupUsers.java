package com.farm.admin.vo;

import java.util.List;

import com.farm.admin.entity.User;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: GroupUsers.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:58:06 <br />
 * 最后修改: 2018-09-05 14:58:06 <br />
 * 修改历史: <br />
 */
public class GroupUsers {
	
	public List<User> members;
	
	public List<User> leaders;
    
    /**
	 * 构造函数
	 */
	public GroupUsers() {
		
	}
	
	public GroupUsers(List<User> members, List<User> leaders) {
		this.members = members;
        this.leaders = leaders;
	}

	/**
	 * 获取 
	 * @return the members
	 */
	public List<User> getMembers() {
		return members;
	}

	/**
	 * 设置 
	 * @param members the members to set
	 */
	public void setMembers(List<User> members) {
		this.members = members;
	}

	/**
	 * 获取 
	 * @return the leaders
	 */
	public List<User> getLeaders() {
		return leaders;
	}

	/**
	 * 设置 
	 * @param leaders the leaders to set
	 */
	public void setLeaders(List<User> leaders) {
		this.leaders = leaders;
	}
}