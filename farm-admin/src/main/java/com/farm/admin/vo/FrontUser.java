package com.farm.admin.vo;

import java.util.List;

import com.farm.api.vo.authority.PermissionInfo;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: FrontUser.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 16:10:29 <br />
 * 最后修改: 2018-09-05 16:10:29 <br />
 * 修改历史: <br />
 */
public class FrontUser {
	
	private String id;

	private String username;

	private String name;

	private String description;

	private String image;

	private List<PermissionInfo> menus;
	
	private List<PermissionInfo> elements;

	/**
	 * 获取
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取
	 * 
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * 设置
	 * 
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * 获取
	 * 
	 * @return the menus
	 */
	public List<PermissionInfo> getMenus() {
		return menus;
	}

	/**
	 * 设置
	 * 
	 * @param menus the menus to set
	 */
	public void setMenus(List<PermissionInfo> menus) {
		this.menus = menus;
	}

	/**
	 * 获取
	 * 
	 * @return the elements
	 */
	public List<PermissionInfo> getElements() {
		return elements;
	}

	/**
	 * 设置
	 * 
	 * @param elements the elements to set
	 */
	public void setElements(List<PermissionInfo> elements) {
		this.elements = elements;
	}
}