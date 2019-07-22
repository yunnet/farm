package com.farm.auth.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ClientConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 13:02:29 <br />
 * 最后修改: 2018-09-04 13:02:29 <br />
 * 修改历史: <br />
 */
@Configuration
public class ClientConfiguration {
	/**
	 * 客户端标识 
	 */
	@Value("${client.id}")
    private String clientId;
    
	/**
	 * 客户端加盐
	 */
    @Value("${client.secret}")
    private String clientSecret;
    
    /**
     * 客户端token传输标识
     */
    @Value("${client.token-header}")
    private String clientTokenHeader;

	/**
	 * 获取 
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * 获取 
	 * @return the clientSecret
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * 获取 
	 * @return the clientTokenHeader
	 */
	public String getClientTokenHeader() {
		return clientTokenHeader;
	}
}