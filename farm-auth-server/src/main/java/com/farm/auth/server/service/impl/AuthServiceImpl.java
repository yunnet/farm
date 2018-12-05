package com.farm.auth.server.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.farm.auth.server.feign.IUserService;
import com.farm.auth.server.service.AuthService;
import com.farm.auth.server.util.user.JwtAuthenticationRequest;
import com.farm.auth.server.util.user.JwtTokenUtil;
import com.farm.api.vo.user.UserInfo;
import com.farm.auth.common.jwt.JWTInfo;
import com.farm.common.exception.auth.UserInvalidException;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: AuthServiceImpl.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-04 11:49:26 <br />
 * 最后修改: 2018-09-04 11:49:26 <br />
 * 修改历史: <br />
 */
@Service
public class AuthServiceImpl implements AuthService {

	private final JwtTokenUtil jwtTokenUtil;
	
	private final IUserService userService;
	
	/**
	 * 构造函数
	 * @param jwtTokenUtil
	 * @param userService
	 */
	public AuthServiceImpl(JwtTokenUtil jwtTokenUtil, IUserService userService) {
		this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
	}

	/**
	 * 登录验证
	 */
	@Override
	public String login(JwtAuthenticationRequest request) throws Exception {
		UserInfo info = userService.validate(request);
        if (!StringUtils.isEmpty(info.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
        }
        
        throw new UserInvalidException("用户不存在或账户密码错误!");
	}

	/**
	 * token刷新
	 */
	@Override
	public String refresh(String oldToken) throws Exception {
		return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(oldToken));
	}

	@Override
	public void validate(String token) throws Exception {
		jwtTokenUtil.getInfoFromToken(token);
	}
}