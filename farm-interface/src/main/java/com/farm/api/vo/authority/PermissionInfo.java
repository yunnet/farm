package com.farm.api.vo.authority;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: PermissionInfo.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 11:16:29 <br />
 * 最后修改: 2018-09-04 11:16:29 <br />
 * 修改历史: <br />
 */
public class PermissionInfo {
	
	private String code;
	
    private String type;
    
    private String uri;
    
    private String method;
    
    private String name;
    
    private String menu;
    
	/**
	 * 获取 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 获取 
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 获取 
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	
	/**
	 * 设置 
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	/**
	 * 获取 
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	
	/**
	 * 设置 
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
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
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}
	
	/**
	 * 设置 
	 * @param menu the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
}