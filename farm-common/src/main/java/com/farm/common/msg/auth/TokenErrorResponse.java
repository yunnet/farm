package com.farm.common.msg.auth;

import com.farm.common.constant.RestCodeConstants;
import com.farm.common.msg.BaseResponse;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: TokenErrorResponse.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 11:19:17 <br />
 * 最后修改: 2018-09-12 11:19:17 <br />
 * 修改历史: <br />
 */
public class TokenErrorResponse extends BaseResponse {
	
	/**
	 * 构造函数
	 * @param msg
	 */
	public TokenErrorResponse(String msg) {
		super(RestCodeConstants.TOKEN_ERROR_CODE, msg);
	}
}