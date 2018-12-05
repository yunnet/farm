package com.farm.auth.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: KeyConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:17:39 <br />
 * 最后修改: 2018-09-04 10:17:39 <br />
 * 修改历史: <br />
 */
@Configuration
@Data
public class KeyConfiguration {
	
	@Value("${jwt.rsa-secret}")
    private String userSecret;
    
    @Value("${client.rsa-secret}")
    private String serviceSecret;
    
    /**
     * 用户的公钥
     */
    private byte[] userPubKey;
    
    /**
     * 用户的私钥
     */
    private byte[] userPriKey;
    
    /**
     * 服务程序的公钥
     */
    private byte[] servicePubKey;
    
    /**
     * 服务程序的私钥
     */
    private byte[] servicePriKey;
}
