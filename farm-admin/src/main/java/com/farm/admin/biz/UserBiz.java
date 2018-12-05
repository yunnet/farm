package com.farm.admin.biz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.admin.entity.User;
import com.farm.admin.mapper.UserMapper;
import com.farm.cache.annotation.Cache;
import com.farm.cache.annotation.CacheClear;
import com.farm.common.biz.BaseBiz;
import com.farm.common.constant.UserConstant;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: UserBiz.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 15:21:17 <br />
 * 最后修改: 2018-09-05 15:21:17 <br />
 * 修改历史: <br />
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper, User> {
    
    @Override
    public void insertSelective(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    @CacheClear(pre="user{1.username}")
    public void updateSelectiveById(User entity) {
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Cache(key="user{1}")
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }


}
