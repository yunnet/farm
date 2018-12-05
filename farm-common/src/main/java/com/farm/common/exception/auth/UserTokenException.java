package com.farm.common.exception.auth;

import com.farm.common.constant.CommonConstants;
import com.farm.common.exception.BaseException;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: UserTokenException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:49:13 <br />
 * 最后修改: 2018-09-03 15:49:13 <br />
 * 修改历史: <br />
 */
public class UserTokenException extends BaseException{
	private static final long serialVersionUID = -7608927096658945583L;

	public UserTokenException(String message) {
		super(message, CommonConstants.EX_USER_INVALID_CODE);
	}

}
