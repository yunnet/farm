package com.farm.auth.server.mapper;

import java.util.List;

import com.farm.auth.server.entity.Client;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ClientMapper.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:06:02 <br />
 * 最后修改: 2018-09-04 10:06:02 <br />
 * 修改历史: <br />
 */
public interface ClientMapper extends Mapper<Client> {
	
	public List<String> selectAllowedClient(String serviceId);

	public List<Client> selectAuthorityServiceInfo(int clientId);
}