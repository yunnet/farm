package com.farm.auth.client.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: UserAuthConfig.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:12:45 <br />
 * 最后修改: 2018-09-04 17:12:45 <br />
 * 修改历史: <br />
 */
public class UserAuthConfig {
	
	@Value("${auth.user.token-header}")
    private String tokenHeader;   //Authorization
	
	private byte[] pubKeyByte;

	/**
	 * 获取 
	 * @return the tokenHeader
	 */
	public String getTokenHeader() {
		return tokenHeader;
	}

	/**
	 * 设置 
	 * @param tokenHeader the tokenHeader to set
	 */
	public void setTokenHeader(String tokenHeader) {
		this.tokenHeader = tokenHeader;
	}

	/**
	 * 获取 
	 * @return the pubKeyByte
	 */
	public byte[] getPubKeyByte() {
		return pubKeyByte;
	}

	/**
	 * 设置 
	 * @param pubKeyByte the pubKeyByte to set
	 */
	public void setPubKeyByte(byte[] pubKeyByte) {
		this.pubKeyByte = pubKeyByte;
	}
	
	public String getToken(HttpServletRequest request) {
		return request.getHeader(this.getTokenHeader());
	}
}