package com.farm.cache.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: CacheBean.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 11:48:48 <br />
 * 最后修改: 2018-09-05 11:48:48 <br />
 * 修改历史: <br />
 */
public class CacheBean {
	private String key = "";
	
    private String desc = "";
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;
    
    /**
	 * 构造函数 
	 */
	public CacheBean() {
		
	}
	
	public CacheBean(String key, Date expireTime) {
		this.key = key;
        this.expireTime = expireTime;
	}
	
	public CacheBean(String key, String desc, Date expireTime) {
		this.key = key;
        this.desc = desc;
        this.expireTime = expireTime;
	}

	/**
	 * 获取 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 设置 
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 获取 
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 设置 
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 获取 
	 * @return the expireTime
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * 设置 
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
}