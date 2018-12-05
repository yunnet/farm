package com.farm.auth.client.exception;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: JwtSignatureException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 18:03:35 <br />
 * 最后修改: 2018-09-04 18:03:35 <br />
 * 修改历史: <br />
 */
public class JwtSignatureException extends Exception {
	private static final long serialVersionUID = 6347042698263527660L;

	public JwtSignatureException(String s) {
		super(s);
	}
}
