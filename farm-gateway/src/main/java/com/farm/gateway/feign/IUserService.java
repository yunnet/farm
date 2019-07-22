package com.farm.gateway.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.farm.gateway.fallback.UserServiceFallback;
import com.farm.api.vo.authority.PermissionInfo;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: IUserService.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 10:28:54 <br />
 * 最后修改: 2018-09-12 10:28:54 <br />
 * 修改历史: <br />
 */
@FeignClient(value = "farm-admin", fallback = UserServiceFallback.class)
public interface IUserService {
	
	@RequestMapping(value="/api/user/un/{username}/permissions", method = RequestMethod.GET)
	public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);
	
	@RequestMapping(value = "/api/permissions", method = RequestMethod.GET)
	public List<PermissionInfo> getAllPermissionInfo();
}