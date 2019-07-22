package com.farm.admin.rpc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.farm.admin.biz.ElementBiz;
import com.farm.admin.biz.MenuBiz;
import com.farm.admin.biz.UserBiz;
import com.farm.admin.constant.AdminCommonConstant;
import com.farm.admin.entity.Element;
import com.farm.admin.entity.Menu;
import com.farm.admin.entity.User;
import com.farm.admin.vo.FrontUser;
import com.farm.admin.vo.MenuTree;
import com.farm.api.vo.authority.PermissionInfo;
import com.farm.api.vo.user.UserInfo;
import com.farm.auth.client.jwt.UserAuthUtil;
import com.farm.common.constant.CommonConstants;
import com.farm.common.util.TreeUtil;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: PermissionService.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 16:11:11 <br />
 * 最后修改: 2018-09-05 16:11:11 <br />
 * 修改历史: <br />
 */
@Service
public class PermissionService {
	@Autowired
    private UserBiz userBiz;
	
    @Autowired
    private MenuBiz menuBiz;
    
    @Autowired
    private ElementBiz elementBiz;
    
    @Autowired
    private UserAuthUtil userAuthUtil;
    
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserInfo getUserByUsername(String username) {
        UserInfo info = new UserInfo();        
        User user = userBiz.getUserByUsername(username);
        
        BeanUtils.copyProperties(user, info);
        info.setId(user.getId().toString());
        return info;
    }

    public UserInfo validate(String username, String password){
        UserInfo info = new UserInfo();
        
        User user = userBiz.getUserByUsername(username);
        if (encoder.matches(password, user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId().toString());
        }
        return info;
    }

    public List<PermissionInfo> getAllPermission() {
        List<Menu> menus = menuBiz.selectListAll();
        List<PermissionInfo> result = new ArrayList<>();
    
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAllElementPermissions();
        element2permission(result, elements);
        return result;
    }

    private void menu2permission(List<Menu> menus, List<PermissionInfo> result) {
        PermissionInfo info;
        for (Menu menu : menus) {
            if (StringUtils.isBlank(menu.getHref())) {
                menu.setHref("/" + menu.getCode());
            }
            
            info = new PermissionInfo();
            info.setCode(menu.getCode());
            info.setType(AdminCommonConstant.RESOURCE_TYPE_MENU);
            info.setName(AdminCommonConstant.RESOURCE_ACTION_VISIT);
            
            String uri = menu.getHref();
            if (!uri.startsWith("/")) {
                uri = "/" + uri;
            }
            
            info.setUri(uri);
            info.setMethod(AdminCommonConstant.RESOURCE_REQUEST_METHOD_GET);
            result.add(info);
            
            info.setMenu(menu.getTitle());
        }
    }

    public List<PermissionInfo> getPermissionByUsername(String username) {
        User user = userBiz.getUserByUsername(username);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        List<PermissionInfo> result = new ArrayList<>();     
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAuthorityElementByUserId(user.getId() + "");
        element2permission(result, elements);
        return result;
    }

    private void element2permission(List<PermissionInfo> result, List<Element> elements) {
    	elements.forEach(element -> {
    		PermissionInfo info = new PermissionInfo();
            info.setCode(element.getCode());
            info.setType(element.getType());
            info.setUri(element.getUri());
            info.setMethod(element.getMethod());
            info.setName(element.getName());
            info.setMenu(element.getMenuId());
            result.add(info);
    	});
    }

    private List<MenuTree> getMenuTree(List<Menu> menus, int root) {
        List<MenuTree> trees = new ArrayList<>();
        menus.forEach(menu -> {
        	MenuTree node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        });

        return TreeUtil.bulid(trees, root);
    }

    public FrontUser getUserInfo(String token) throws Exception {
        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
        if (username == null) {
            return null;
        }
        
        UserInfo user = this.getUserByUsername(username);
        FrontUser frontUser = new FrontUser();
        BeanUtils.copyProperties(user, frontUser);
        
        List<PermissionInfo> permissionInfos = this.getPermissionByUsername(username);
        Stream<PermissionInfo> menus = permissionInfos.parallelStream().filter((permission) -> {
            return permission.getType().equals(CommonConstants.RESOURCE_TYPE_MENU);
        });
        
        frontUser.setMenus(menus.collect(Collectors.toList()));
        Stream<PermissionInfo> elements = permissionInfos.parallelStream().filter((permission) -> {
            return !permission.getType().equals(CommonConstants.RESOURCE_TYPE_MENU);
        });
        
        frontUser.setElements(elements.collect(Collectors.toList()));
        return frontUser;
    }

    public List<MenuTree> getMenusByUsername(String token) throws Exception {
        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        
        User user = userBiz.getUserByUsername(username);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        return getMenuTree(menus,AdminCommonConstant.ROOT);
    }
}