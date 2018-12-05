package com.farm.admin.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.admin.constant.AdminCommonConstant;
import com.farm.admin.entity.Group;
import com.farm.admin.entity.Menu;
import com.farm.admin.entity.ResourceAuthority;
import com.farm.admin.mapper.GroupMapper;
import com.farm.admin.mapper.MenuMapper;
import com.farm.admin.mapper.ResourceAuthorityMapper;
import com.farm.admin.mapper.UserMapper;
import com.farm.admin.vo.AuthorityMenuTree;
import com.farm.admin.vo.GroupUsers;
import com.farm.cache.annotation.CacheClear;
import com.farm.common.biz.BaseBiz;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: GroupBiz.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:52:42 <br />
 * 最后修改: 2018-09-05 14:52:42 <br />
 * 修改历史: <br />
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupBiz extends BaseBiz<GroupMapper, Group> {
	@Autowired
    private UserMapper userMapper;
	
    @Autowired
    private ResourceAuthorityMapper resourceAuthorityMapper;
    
    @Autowired
    private MenuMapper menuMapper;
    
    @Override
    public void insertSelective(Group entity) {
        if (AdminCommonConstant.ROOT == entity.getParentId()) {
            entity.setPath("/" + entity.getCode());
        } else {
            Group parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath() + "/" + entity.getCode());
        }
        super.insertSelective(entity);
    }

    @Override
    public void updateById(Group entity) {
        if (AdminCommonConstant.ROOT == entity.getParentId()) {
            entity.setPath("/" + entity.getCode());
        } else {
            Group parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath() + "/" + entity.getCode());
        }
        super.updateById(entity);
    }

    /**
     * 获取群组关联用户
     *
     * @param groupId
     * @return
     */
    public GroupUsers getGroupUsers(int groupId) {
        return new GroupUsers(userMapper.selectMemberByGroupId(groupId), userMapper.selectLeaderByGroupId(groupId));
    }

    /**
     * 变更群主所分配用户
     *
     * @param groupId
     * @param members
     * @param leaders
     */
    @CacheClear(pre = "permission")
    public void modifyGroupUsers(int groupId, String members, String leaders) {
        mapper.deleteGroupLeadersById(groupId);
        mapper.deleteGroupMembersById(groupId);
        if (!StringUtils.isEmpty(members)) {
            String[] mem = members.split(",");
            for (String m : mem) {
                mapper.insertGroupMembersById(groupId, Integer.parseInt(m));
            }
        }
        if (!StringUtils.isEmpty(leaders)) {
            String[] mem = leaders.split(",");
            for (String m : mem) {
                mapper.insertGroupLeadersById(groupId, Integer.parseInt(m));
            }
        }
    }

    /**
     * 变更群组关联的菜单
     *
     * @param groupId
     * @param menus
     */
    @CacheClear(keys = {"permission:menu","permission:u"})
    public void modifyAuthorityMenu(int groupId, String[] menus) {
        resourceAuthorityMapper.deleteByAuthorityIdAndResourceType(groupId + "", AdminCommonConstant.RESOURCE_TYPE_MENU);
        Map<String, String> map = new HashMap<>();
        List<Menu> menuList = menuMapper.selectAll();
        for (Menu menu : menuList) {
            map.put(menu.getId().toString(), menu.getParentId().toString());
        }
        
        Set<String> relationMenus = new HashSet<>();
        relationMenus.addAll(Arrays.asList(menus));
        
        for (String menuId : menus) {
            findParentID(map, relationMenus, menuId);
        }
        
        ResourceAuthority authority = null;
        for (String menuId : relationMenus) {
            authority = new ResourceAuthority(AdminCommonConstant.AUTHORITY_TYPE_GROUP, AdminCommonConstant.RESOURCE_TYPE_MENU);
            authority.setAuthorityId(groupId + "");
            authority.setResourceId(menuId);
            authority.setParentId("-1");
            resourceAuthorityMapper.insertSelective(authority);
        }
    }

    private void findParentID(Map<String, String> map, Set<String> relationMenus, String id) {
        String parentId = map.get(id);
        if (String.valueOf(AdminCommonConstant.ROOT).equals(id)) {
            return;
        }
        relationMenus.add(parentId);
        
        findParentID(map, relationMenus, parentId);
    }

    /**
     * 分配资源权限
     *
     * @param groupId
     * @param menuId
     * @param elementId
     */
    @CacheClear(keys = {"permission:ele","permission:u"})
    public void modifyAuthorityElement(int groupId, int menuId, int elementId) {
        ResourceAuthority authority = new ResourceAuthority(AdminCommonConstant.AUTHORITY_TYPE_GROUP, AdminCommonConstant.RESOURCE_TYPE_BTN);
        authority.setAuthorityId(groupId + "");
        authority.setResourceId(elementId + "");
        authority.setParentId("-1");
        
        resourceAuthorityMapper.insertSelective(authority);
    }

    /**
     * 移除资源权限
     *
     * @param groupId
     * @param menuId
     * @param elementId
     */
    @CacheClear(keys = {"permission:ele","permission:u"})
    public void removeAuthorityElement(int groupId, int menuId, int elementId) {
        ResourceAuthority authority = new ResourceAuthority();
        authority.setAuthorityId(groupId + "");
        authority.setResourceId(elementId + "");
        authority.setParentId("-1");
        
        resourceAuthorityMapper.delete(authority);
    }


    /**
     * 获取群主关联的菜单
     *
     * @param groupId
     * @return
     */
    public List<AuthorityMenuTree> getAuthorityMenu(int groupId) {
        List<Menu> menus = menuMapper.selectMenuByAuthorityId(String.valueOf(groupId), AdminCommonConstant.AUTHORITY_TYPE_GROUP);
        List<AuthorityMenuTree> trees = new ArrayList<>();
        
        AuthorityMenuTree node = null;
        for (Menu menu : menus) {
            node = new AuthorityMenuTree();
            node.setText(menu.getTitle());
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return trees;
    }

    /**
     * 获取群组关联的资源
     *
     * @param groupId
     * @return
     */
    public List<Integer> getAuthorityElement(int groupId) {
        ResourceAuthority authority = new ResourceAuthority(AdminCommonConstant.AUTHORITY_TYPE_GROUP, AdminCommonConstant.RESOURCE_TYPE_BTN);
        authority.setAuthorityId(groupId + "");
        List<ResourceAuthority> authorities = resourceAuthorityMapper.select(authority);
        
        List<Integer> ids = new ArrayList<>();
        for (ResourceAuthority auth : authorities) {
            ids.add(Integer.parseInt(auth.getResourceId()));
        }
        return ids;
    }

}
