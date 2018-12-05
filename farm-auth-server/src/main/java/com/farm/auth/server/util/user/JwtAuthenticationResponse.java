package com.farm.auth.server.util.user;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: JwtAuthenticationResponse.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:33:08 <br />
 * 最后修改: 2018-09-04 10:33:08 <br />
 * 修改历史: <br />
 */
public class JwtAuthenticationResponse {
	
	private final String token;
	
	/**
	 * 构造函数
	 * @param token
	 */
	public JwtAuthenticationResponse(String token) {
		this.token = token;
	}

	/**
	 * 获取 
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
}