package com.farm.auth.client.exception;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: JwtTokenExpiredException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 18:04:42 <br />
 * 最后修改: 2018-09-04 18:04:42 <br />
 * 修改历史: <br />
 */
public class JwtTokenExpiredException extends Exception {
	private static final long serialVersionUID = -8054839169938098748L;

	public JwtTokenExpiredException(String s) {
		super(s);
	}
}
