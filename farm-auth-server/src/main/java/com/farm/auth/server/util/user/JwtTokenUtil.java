package com.farm.auth.server.util.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.farm.auth.server.configuration.KeyConfiguration;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.auth.common.jwt.JWTHelper;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: JwtTokenUtil.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 11:50:23 <br />
 * 最后修改: 2018-09-04 11:50:23 <br />
 * 修改历史: <br />
 */
@Component
public class JwtTokenUtil {
	@Value("${jwt.expire}")
    private int expire;
	
	@Autowired
    private KeyConfiguration keyConfiguration;
	
	public String generateToken(IJWTInfo jwtInfo) throws Exception {
		return JWTHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(), expire);
	}

	public IJWTInfo getInfoFromToken(String token) throws Exception {
		return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
	}
}