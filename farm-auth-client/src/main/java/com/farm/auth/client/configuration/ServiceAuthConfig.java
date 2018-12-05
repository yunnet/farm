package com.farm.auth.client.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ServiceAuthConfig.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:13:05 <br />
 * 最后修改: 2018-09-04 17:13:05 <br />
 * 修改历史: <br />
 */
public class ServiceAuthConfig {
	
	private byte[] pubKeyByte;
	
    @Value("${auth.client.id:null}")
    private String clientId;
    
    @Value("${auth.client.secret}")
    private String clientSecret;
    
    @Value("${auth.client.token-header}")
    private String tokenHeader;    //x-client-token
    
    @Value("${spring.application.name}")
    private String applicationName;

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

	/**
	 * 获取 
	 * @return the clientId
	 */
	public String getClientId() {
		return "null".equals(clientId) ? applicationName : clientId;
	}

	/**
	 * 设置 
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * 获取 
	 * @return the clientSecret
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * 设置 
	 * @param clientSecret the clientSecret to set
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

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
	
	public String getToken(HttpServletRequest request){
        return request.getHeader(this.getTokenHeader());
    }
}