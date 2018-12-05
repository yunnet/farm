package com.farm.admin.vo;

import com.farm.common.vo.TreeNode;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: MenuTree.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 16:05:01 <br />
 * 最后修改: 2018-09-05 16:05:01 <br />
 * 修改历史: <br />
 */
public class MenuTree extends TreeNode {
	
	private String icon;
	
	private String title;
	
	private String href;
	
	private boolean spread = false;
	
	private String path;
	
	private String component;
	
	private String authority;
	
	private String redirect;
	
	private String code;
	
	private String label;
	
	/**
	 * 构造函数
	 */
	public MenuTree() {
		
	}
	
	/**
	 * 构造函数
	 * @param id
	 * @param name
	 * @param parentId
	 */
	public MenuTree(int id, String name, int parentId) {
		this.id = id;
        this.parentId = parentId;
        this.title = name;
        this.label = name;
	}
	
	/**
	 * 构造函数
	 * @param id
	 * @param name
	 * @param parent
	 */
	public MenuTree(int id, String name, MenuTree parent) {
		this.id = id;
        this.parentId = parent.getId();
        this.title = name;
        this.label = name;

	}

	/**
	 * 获取
	 * 
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置
	 * 
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 获取
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取
	 * 
	 * @return the href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * 设置
	 * 
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * 获取
	 * 
	 * @return the spread
	 */
	public boolean isSpread() {
		return spread;
	}

	/**
	 * 设置
	 * 
	 * @param spread the spread to set
	 */
	public void setSpread(boolean spread) {
		this.spread = spread;
	}

	/**
	 * 获取
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 设置
	 * 
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 获取
	 * 
	 * @return the component
	 */
	public String getComponent() {
		return component;
	}

	/**
	 * 设置
	 * 
	 * @param component the component to set
	 */
	public void setComponent(String component) {
		this.component = component;
	}

	/**
	 * 获取
	 * 
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * 设置
	 * 
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * 获取
	 * 
	 * @return the redirect
	 */
	public String getRedirect() {
		return redirect;
	}

	/**
	 * 设置
	 * 
	 * @param redirect the redirect to set
	 */
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	/**
	 * 获取
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置
	 * 
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 设置
	 * 
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}