package com.farm.common.exception.auth;

import com.farm.common.constant.CommonConstants;
import com.farm.common.exception.BaseException;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ClientTokenException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:54:37 <br />
 * 最后修改: 2018-09-03 15:54:37 <br />
 * 修改历史: <br />
 */
public class ClientTokenException extends BaseException {
	private static final long serialVersionUID = 933237181436789274L;

	public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
