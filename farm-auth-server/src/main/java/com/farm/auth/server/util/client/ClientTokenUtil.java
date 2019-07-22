package com.farm.auth.server.util.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.farm.auth.server.configuration.KeyConfiguration;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.auth.common.jwt.JWTHelper;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ClientTokenUtil.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:56:48 <br />
 * 最后修改: 2018-09-04 10:56:48 <br />
 * 修改历史: <br />
 */
@Configuration
public class ClientTokenUtil {
	@Value("${client.expire}")
	private int expire;
	
	@Autowired
	private KeyConfiguration keyConfiguration;
	
	public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getServicePriKey(), expire);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, keyConfiguration.getServicePubKey());
    }
}