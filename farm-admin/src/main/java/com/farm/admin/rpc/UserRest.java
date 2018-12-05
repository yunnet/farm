package com.farm.admin.rpc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.admin.rpc.service.PermissionService;
import com.farm.api.vo.authority.PermissionInfo;
import com.farm.api.vo.user.UserInfo;
import com.farm.cache.annotation.Cache;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: UserRest.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 16:11:49 <br />
 * 最后修改: 2018-09-05 16:11:49 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("api")
public class UserRest {
	@Autowired
	private PermissionService permissionService;

	@Cache(key = "/permission")
	@RequestMapping(value = "/permissions", method = RequestMethod.GET)
	public List<PermissionInfo> getAllPermission() {
		return permissionService.getAllPermission();
	}

	@Cache(key = "/permission:u{1}")
	@RequestMapping(value = "/user/un/{username}/permissions", method = RequestMethod.GET)
	public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username) {
		return permissionService.getPermissionByUsername(username);
	}

	@RequestMapping(value = "/user/validate", method = RequestMethod.POST)
	public UserInfo validate(@RequestBody Map<String, String> body) {
		return permissionService.validate(body.get("username"), body.get("password"));
	}
}