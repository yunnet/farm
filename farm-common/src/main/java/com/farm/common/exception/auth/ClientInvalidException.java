package com.farm.common.exception.auth;

import com.farm.common.constant.CommonConstants;
import com.farm.common.exception.BaseException;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ClientInvalidException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:59:47 <br />
 * 最后修改: 2018-09-03 15:59:47 <br />
 * 修改历史: <br />
 */
public class ClientInvalidException extends BaseException {
	private static final long serialVersionUID = -4450908460332282887L;
	
	public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}