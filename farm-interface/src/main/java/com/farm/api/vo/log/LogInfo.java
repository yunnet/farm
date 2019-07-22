package com.farm.api.vo.log;

import java.util.Date;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: LogInfo.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 11:13:26 <br />
 * 最后修改: 2018-09-04 11:13:26 <br />
 * 修改历史: <br />
 */
public class LogInfo {
	/**
	 * 菜单
	 */
	private String menu;

	/**
	 * 操作
	 */
    private String opt;

    /**
     * 资源路径
     */
    private String uri;

    /**
     * 操作时间
     */
    private Date crtTime;

    /**
     * 操作人ID
     */
    private String crtUser;

    /**
     * 操作人
     */
    private String crtName;

    /**
     * 操作主机
     */
    private String crtHost;
    
    /**
	 * 构造函数
	 */
	public LogInfo() {
		
	}
	
	/**
	 * 构造函数
	 * @param menu
	 * @param option
	 * @param uri
	 * @param crtTime
	 * @param crtUser
	 * @param crtName
	 * @param crtHost
	 */
	public LogInfo(String menu, String option, String uri,  Date crtTime, String crtUser, String crtName, String crtHost) {
		this.menu = menu;
        this.opt = option;
        this.uri = uri;
        this.crtTime = crtTime;
        this.crtUser = crtUser;
        this.crtName = crtName;
        this.crtHost = crtHost;
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

	/**
	 * 获取 
	 * @return the opt
	 */
	public String getOpt() {
		return opt;
	}

	/**
	 * 设置 
	 * @param opt the opt to set
	 */
	public void setOpt(String opt) {
		this.opt = opt;
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
	 * @return the crtTime
	 */
	public Date getCrtTime() {
		return crtTime;
	}

	/**
	 * 设置 
	 * @param crtTime the crtTime to set
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	/**
	 * 获取 
	 * @return the crtUser
	 */
	public String getCrtUser() {
		return crtUser;
	}

	/**
	 * 设置 
	 * @param crtUser the crtUser to set
	 */
	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	/**
	 * 获取 
	 * @return the crtName
	 */
	public String getCrtName() {
		return crtName;
	}

	/**
	 * 设置 
	 * @param crtName the crtName to set
	 */
	public void setCrtName(String crtName) {
		this.crtName = crtName;
	}

	/**
	 * 获取 
	 * @return the crtHost
	 */
	public String getCrtHost() {
		return crtHost;
	}

	/**
	 * 设置 
	 * @param crtHost the crtHost to set
	 */
	public void setCrtHost(String crtHost) {
		this.crtHost = crtHost;
	}
}