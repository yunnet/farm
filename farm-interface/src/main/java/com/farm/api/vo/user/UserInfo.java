package com.farm.api.vo.user;

import java.util.Date;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: UserInfo.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-04 11:18:39 <br />
 * 最后修改: 2018-09-04 11:18:39 <br />
 * 修改历史: <br />
 */
public class UserInfo {
	/**
	 * 序号
	 */
	public String id;
	
	/**
	 * 用户名
	 */
	public String username;
	
	/**
	 * 密码
	 */
	public String password;
	
	/**
	 * 名称
	 */
	public String name;
	
	/**
	 * 说明
	 */
	private String description;
	
	/**
	 * 更新时间
	 */
	private Date updTime;
	
	/**
	 * 获取 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 获取 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 获取 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 设置 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 获取 
	 * @return the updTime
	 */
	public Date getUpdTime() {
		return updTime;
	}
	
	/**
	 * 设置 
	 * @param updTime the updTime to set
	 */
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
}