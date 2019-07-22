package com.farm.admin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.admin.biz.MenuBiz;
import com.farm.admin.biz.UserBiz;
import com.farm.admin.entity.Menu;
import com.farm.admin.entity.User;
import com.farm.admin.rpc.service.PermissionService;
import com.farm.admin.vo.FrontUser;
import com.farm.admin.vo.MenuTree;
import com.farm.common.rest.BaseController;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: UserController.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 16:09:34 <br />
 * 最后修改: 2018-09-05 16:09:34 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz, User> {

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private MenuBiz menuBiz;

	@RequestMapping(value = "/front/info", method = RequestMethod.GET)
	public ResponseEntity<?> getUserInfo(String token) throws Exception {
		FrontUser userInfo = permissionService.getUserInfo(token);
		if (userInfo == null) {
			return ResponseEntity.status(401).body(false);
		} else {
			return ResponseEntity.ok(userInfo);
		}
	}

	@RequestMapping(value = "/front/menus", method = RequestMethod.GET)
	public List<MenuTree> getMenusByUsername(String token) throws Exception {
		return permissionService.getMenusByUsername(token);
	}

	@RequestMapping(value = "/front/menu/all", method = RequestMethod.GET)
	public List<Menu> getAllMenus() throws Exception {
		return menuBiz.selectListAll();
	}
}