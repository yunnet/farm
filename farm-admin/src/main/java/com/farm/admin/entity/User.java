package com.farm.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: User.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 09:37:57 <br />
 * 最后修改: 2018-09-05 09:37:57 <br />
 * 修改历史: <br />
 */
@Table(name = "base_user")
public class User {
	@Id
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String birthday;

    private String address;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "tel_phone")
    private String telPhone;

    private String email;

    private String sex;

    private String type;

    private String description;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;

    @Column(name = "upd_time")
    private Date updTime;

    @Column(name = "upd_user")
    private String updUser;

    @Column(name = "upd_name")
    private String updName;

    @Column(name = "upd_host")
    private String updHost;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    private String attr6;

    private String attr7;

    private String attr8;

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
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 设置 
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 获取 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取 
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * 设置 
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * 获取 
	 * @return the telPhone
	 */
	public String getTelPhone() {
		return telPhone;
	}

	/**
	 * 设置 
	 * @param telPhone the telPhone to set
	 */
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	/**
	 * 获取 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取 
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置 
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
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

	/**
	 * 获取 
	 * @return the updUser
	 */
	public String getUpdUser() {
		return updUser;
	}

	/**
	 * 设置 
	 * @param updUser the updUser to set
	 */
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	/**
	 * 获取 
	 * @return the updName
	 */
	public String getUpdName() {
		return updName;
	}

	/**
	 * 设置 
	 * @param updName the updName to set
	 */
	public void setUpdName(String updName) {
		this.updName = updName;
	}

	/**
	 * 获取 
	 * @return the updHost
	 */
	public String getUpdHost() {
		return updHost;
	}

	/**
	 * 设置 
	 * @param updHost the updHost to set
	 */
	public void setUpdHost(String updHost) {
		this.updHost = updHost;
	}

	/**
	 * 获取 
	 * @return the attr1
	 */
	public String getAttr1() {
		return attr1;
	}

	/**
	 * 设置 
	 * @param attr1 the attr1 to set
	 */
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	/**
	 * 获取 
	 * @return the attr2
	 */
	public String getAttr2() {
		return attr2;
	}

	/**
	 * 设置 
	 * @param attr2 the attr2 to set
	 */
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	/**
	 * 获取 
	 * @return the attr3
	 */
	public String getAttr3() {
		return attr3;
	}

	/**
	 * 设置 
	 * @param attr3 the attr3 to set
	 */
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	/**
	 * 获取 
	 * @return the attr4
	 */
	public String getAttr4() {
		return attr4;
	}

	/**
	 * 设置 
	 * @param attr4 the attr4 to set
	 */
	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	/**
	 * 获取 
	 * @return the attr5
	 */
	public String getAttr5() {
		return attr5;
	}

	/**
	 * 设置 
	 * @param attr5 the attr5 to set
	 */
	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	/**
	 * 获取 
	 * @return the attr6
	 */
	public String getAttr6() {
		return attr6;
	}

	/**
	 * 设置 
	 * @param attr6 the attr6 to set
	 */
	public void setAttr6(String attr6) {
		this.attr6 = attr6;
	}

	/**
	 * 获取 
	 * @return the attr7
	 */
	public String getAttr7() {
		return attr7;
	}

	/**
	 * 设置 
	 * @param attr7 the attr7 to set
	 */
	public void setAttr7(String attr7) {
		this.attr7 = attr7;
	}

	/**
	 * 获取 
	 * @return the attr8
	 */
	public String getAttr8() {
		return attr8;
	}

	/**
	 * 设置 
	 * @param attr8 the attr8 to set
	 */
	public void setAttr8(String attr8) {
		this.attr8 = attr8;
	}
}