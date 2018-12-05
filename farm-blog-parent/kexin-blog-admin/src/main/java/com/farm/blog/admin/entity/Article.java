package com.farm.blog.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: Article.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-29 15:48:21 <br />
 * 最后修改: 2018-10-29 15:48:21 <br />
 * 修改历史: <br />
 */
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Table(name = "blog_article")
public class Article {
	@Id
    private Integer id;

    private String title;

    private String content;

    private String remark;

    private String tag;

    @Column(name = "is_del")
    private String isDel;

    @Column(name = "page_view")
    private Integer pageView;

    private String cover;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置 
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取 
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取 
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * 设置 
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * 获取 
	 * @return the isDel
	 */
	public String getIsDel() {
		return isDel;
	}

	/**
	 * 设置 
	 * @param isDel the isDel to set
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	/**
	 * 获取 
	 * @return the pageView
	 */
	public Integer getPageView() {
		return pageView;
	}

	/**
	 * 设置 
	 * @param pageView the pageView to set
	 */
	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	/**
	 * 获取 
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}

	/**
	 * 设置 
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
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