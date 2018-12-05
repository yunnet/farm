package com.farm.auth.client.exception;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: JwtIllegalArgumentException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:59:58 <br />
 * 最后修改: 2018-09-04 17:59:58 <br />
 * 修改历史: <br />
 */
public class JwtIllegalArgumentException extends Exception {
	private static final long serialVersionUID = 6042295145098529312L;
	
	public JwtIllegalArgumentException(String s) {
		super(s);
	}
}