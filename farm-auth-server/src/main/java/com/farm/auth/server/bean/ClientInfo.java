package com.farm.auth.server.bean;

import com.farm.auth.common.jwt.IJWTInfo;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ClientInfo.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 08:55:28 <br />
 * 最后修改: 2018-09-04 08:55:28 <br />
 * 修改历史: <br />
 */
public class ClientInfo implements IJWTInfo{
	/**
     * 序号
     */
    String id;
    
	/**
	 * 服务程序序号
	 */
	String clientId;
	
	/**
	 * 服务程序名称
	 */
    String name;
    
    /**
     * 构造函数
     * @param clientId
     * @param name
     * @param id
     */
	public ClientInfo(String clientId, String name, String id) {
		this.id = id;
		this.clientId = clientId;
        this.name = name;
	}

	@Override
	public String getUniqueName() {
		return clientId;
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
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
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * 设置 
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * 设置 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}