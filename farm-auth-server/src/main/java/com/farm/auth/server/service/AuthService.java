package com.farm.auth.server.service;

import com.farm.auth.server.util.user.JwtAuthenticationRequest;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: AuthService.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:30:36 <br />
 * 最后修改: 2018-09-04 10:30:36 <br />
 * 修改历史: <br />
 */
public interface AuthService {
	
	public String login(JwtAuthenticationRequest request) throws Exception;

	public String refresh(String oldToken) throws Exception;
	
	public void validate(String token) throws Exception;
}