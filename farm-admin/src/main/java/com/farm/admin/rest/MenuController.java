package com.farm.admin.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.admin.biz.MenuBiz;
import com.farm.admin.biz.UserBiz;
import com.farm.admin.constant.AdminCommonConstant;
import com.farm.admin.entity.Menu;
import com.farm.admin.vo.AuthorityMenuTree;
import com.farm.admin.vo.MenuTree;
import com.farm.common.rest.BaseController;
import com.farm.common.util.TreeUtil;

import tk.mybatis.mapper.entity.Example;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: MenuController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 15:58:00 <br />
 * 最后修改: 2018-09-05 15:58:00 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController<MenuBiz, Menu> {
	@Autowired
    private UserBiz userBiz;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Menu> list(String title) {
        Example example = new Example(Menu.class);
        if (StringUtils.isNotBlank(title)) {
            example.createCriteria().andLike("title", "%" + title + "%");
        }
        return baseBiz.selectByExample(example);
    }

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public List<MenuTree> getTree(String title) {
        Example example = new Example(Menu.class);
        if (StringUtils.isNotBlank(title)) {
            example.createCriteria().andLike("title", "%" + title + "%");
        }
        return getMenuTree(baseBiz.selectByExample(example), AdminCommonConstant.ROOT);
    }

    @RequestMapping(value = "/system", method = RequestMethod.GET)
    public List<Menu> getSystem() {
        Menu menu = new Menu();
        menu.setParentId(AdminCommonConstant.ROOT);
        return baseBiz.selectList(menu);
    }

    @RequestMapping(value = "/menuTree", method = RequestMethod.GET)
    public List<MenuTree> listMenu(Integer parentId) {
        try {
            if (parentId == null) {
                parentId = this.getSystem().get(0).getId();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        
        Example example = new Example(Menu.class);
        Menu parent = baseBiz.selectById(parentId);
        example.createCriteria().andLike("path", parent.getPath() + "%").andNotEqualTo("id", parent.getId());
        return getMenuTree(baseBiz.selectByExample(example), parent.getId());
    }

    @RequestMapping(value = "/authorityTree", method = RequestMethod.GET)
    public List<AuthorityMenuTree> listAuthorityMenu() {
        List<AuthorityMenuTree> trees = new ArrayList<AuthorityMenuTree>();
        AuthorityMenuTree node = null;
        for (Menu menu : baseBiz.selectListAll()) {
            node = new AuthorityMenuTree();
            node.setText(menu.getTitle());
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return TreeUtil.bulid(trees, AdminCommonConstant.ROOT);
    }

    @RequestMapping(value = "/user/authorityTree", method = RequestMethod.GET)
    public List<MenuTree> listUserAuthorityMenu(Integer parentId){
        int userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
        try {
            if (parentId == null) {
                parentId = this.getSystem().get(0).getId();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return getMenuTree(baseBiz.getUserAuthorityMenuByUserId(userId),parentId);
    }

    @RequestMapping(value = "/user/system", method = RequestMethod.GET)
    public List<Menu> listUserAuthoritySystem() {
        int userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
        return baseBiz.getUserAuthoritySystemByUserId(userId);
    }

    private List<MenuTree> getMenuTree(List<Menu> menus,int root) {
        List<MenuTree> trees = new ArrayList<>();
        for (Menu menu : menus) {
        	MenuTree node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            node.setLabel(menu.getTitle());
            trees.add(node);
        }
        return TreeUtil.bulid(trees, root) ;
    }
}