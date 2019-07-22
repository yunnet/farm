package com.farm.gateway.fallback;

import java.util.List;

import org.springframework.stereotype.Service;

import com.farm.gateway.feign.IUserService;
import com.farm.api.vo.authority.PermissionInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: UserServiceFallback.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 10:32:33 <br />
 * 最后修改: 2018-09-12 10:32:33 <br />
 * 修改历史: <br />
 */
@Service
@Slf4j
public class UserServiceFallback implements IUserService {

	@Override
	public List<PermissionInfo> getPermissionByUsername(String username) {
		log.error("调用{}异常{}", "getPermissionByUsername", username);
        return null;
	}

	@Override
	public List<PermissionInfo> getAllPermissionInfo() {
		log.error("调用{}异常","getPermissionByUsername");
        return null;
	}
}