package com.farm.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: GateLog.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 09:33:18 <br />
 * 最后修改: 2018-09-05 09:33:18 <br />
 * 修改历史: <br />
 */
@Table(name = "gate_log")
public class GateLog {
	
	@Id
    private Integer id;

    private String menu;

    private String opt;

    private String uri;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;

	/**
	 * 获取 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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