package com.farm.auth.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.farm.auth.server.configuration.FeignConfiguration;
import com.farm.auth.server.util.user.JwtAuthenticationRequest;
import com.farm.api.vo.user.UserInfo;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: IUserService.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-04 11:56:40 <br />
 * 最后修改: 2018-09-04 11:56:40 <br />
 * 修改历史: <br />
 */
@FeignClient(value = "farm-admin", configuration = FeignConfiguration.class)
public interface IUserService {

	@RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
	public UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);
}
