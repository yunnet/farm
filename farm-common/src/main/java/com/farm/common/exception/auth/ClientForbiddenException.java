package com.farm.common.exception.auth;

import com.farm.common.constant.CommonConstants;
import com.farm.common.exception.BaseException;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ClientForbiddenException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:59:05 <br />
 * 最后修改: 2018-09-03 15:59:05 <br />
 * 修改历史: <br />
 */
public class ClientForbiddenException extends BaseException {
	private static final long serialVersionUID = -2861114750417316531L;

	public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }
}
