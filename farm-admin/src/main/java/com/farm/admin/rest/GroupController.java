package com.farm.admin.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.admin.biz.GroupBiz;
import com.farm.admin.biz.ResourceAuthorityBiz;
import com.farm.admin.constant.AdminCommonConstant;
import com.farm.admin.entity.Group;
import com.farm.admin.vo.AuthorityMenuTree;
import com.farm.admin.vo.GroupTree;
import com.farm.admin.vo.GroupUsers;
import com.farm.common.msg.ObjectRestResponse;
import com.farm.common.rest.BaseController;
import com.farm.common.util.TreeUtil;

import io.swagger.annotations.Api;
import tk.mybatis.mapper.entity.Example;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: GroupController.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 15:24:27 <br />
 * 最后修改: 2018-09-05 15:24:27 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("group")
@Api("群组模块")
public class GroupController extends BaseController<GroupBiz, Group> {
	@Autowired
	private ResourceAuthorityBiz resourceAuthorityBiz;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Group> list(String name, String groupType) {
		if (StringUtils.isBlank(name) && StringUtils.isBlank(groupType)) {
			return new ArrayList<>();
		}

		Example example = new Example(Group.class);
		if (StringUtils.isNotBlank(name)) {
			example.createCriteria().andLike("name", "%" + name + "%");
		}

		if (StringUtils.isNotBlank(groupType)) {
			example.createCriteria().andEqualTo("groupType", groupType);
		}
		
		return baseBiz.selectByExample(example);
	}

	@RequestMapping(value = "/{id}/user", method = RequestMethod.PUT)
	public ObjectRestResponse modifiyUsers(@PathVariable int id, String members, String leaders) {
		baseBiz.modifyGroupUsers(id, members, leaders);
		return new ObjectRestResponse().rel(true);
	}

	@RequestMapping(value = "/{id}/user", method = RequestMethod.GET)
	public ObjectRestResponse<GroupUsers> getUsers(@PathVariable int id) {
		GroupUsers groupUsers = baseBiz.getGroupUsers(id);
		return new ObjectRestResponse<GroupUsers>().rel(true).data(groupUsers);
	}

	@RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.POST)
	public ObjectRestResponse modifyMenuAuthority(@PathVariable int id, String menuTrees) {
		String[] menus = menuTrees.split(",");
		baseBiz.modifyAuthorityMenu(id, menus);
		return new ObjectRestResponse().rel(true);
	}

	@RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.GET)
	public ObjectRestResponse<List<AuthorityMenuTree>> getMenuAuthority(@PathVariable int id) {
		return new ObjectRestResponse().data(baseBiz.getAuthorityMenu(id)).rel(true);
	}

	@RequestMapping(value = "/{id}/authority/element/add", method = RequestMethod.POST)
	public ObjectRestResponse addElementAuthority(@PathVariable int id, int menuId, int elementId) {
		baseBiz.modifyAuthorityElement(id, menuId, elementId);
		return new ObjectRestResponse().rel(true);
	}

	@RequestMapping(value = "/{id}/authority/element/remove", method = RequestMethod.POST)
	public ObjectRestResponse removeElementAuthority(@PathVariable int id, int menuId, int elementId) {
		baseBiz.removeAuthorityElement(id, menuId, elementId);
		return new ObjectRestResponse().rel(true);
	}

	@RequestMapping(value = "/{id}/authority/element", method = RequestMethod.GET)
	public ObjectRestResponse<List<Integer>> getElementAuthority(@PathVariable int id) {
		return new ObjectRestResponse().data(baseBiz.getAuthorityElement(id)).rel(true);
	}

	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public List<GroupTree> tree(String name, String groupType) {
		if (StringUtils.isBlank(name) && StringUtils.isBlank(groupType)) {
			return new ArrayList<>();
		}
		
		Example example = new Example(Group.class);
		
		if (StringUtils.isNotBlank(name)) {
			example.createCriteria().andLike("name", "%" + name + "%");
		}
		
		if (StringUtils.isNotBlank(groupType)) {
			example.createCriteria().andEqualTo("groupType", groupType);
		}
		
		return getTree(baseBiz.selectByExample(example), AdminCommonConstant.ROOT);
	}

	private List<GroupTree> getTree(List<Group> groups, int root) {
		List<GroupTree> trees = new ArrayList<>();
		GroupTree node = null;
		for (Group group : groups) {
			node = new GroupTree();
			node.setLabel(group.getName());
			BeanUtils.copyProperties(group, node);
			trees.add(node);
		}
		return TreeUtil.bulid(trees, root);
	}
}