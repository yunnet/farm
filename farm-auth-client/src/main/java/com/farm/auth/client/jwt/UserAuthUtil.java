package com.farm.auth.client.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.auth.client.configuration.UserAuthConfig;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.auth.common.jwt.JWTHelper;
import com.farm.common.exception.auth.UserTokenException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: UserAuthUtil.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-04 17:56:09 <br />
 * 最后修改: 2018-09-04 17:56:09 <br />
 * 修改历史: <br />
 */
@Component
public class UserAuthUtil {
	
	@Autowired
	private UserAuthConfig userAuthConfig;

	public IJWTInfo getInfoFromToken(String token) throws Exception {
		try {
			return JWTHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
		} catch (ExpiredJwtException ex) {
			throw new UserTokenException("User token expired!");
		} catch (SignatureException ex) {
			throw new UserTokenException("User token signature error!");
		} catch (IllegalArgumentException ex) {
			throw new UserTokenException("User token is null or empty!");
		}
	}
}