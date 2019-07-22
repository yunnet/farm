package com.farm.auth.server.mapper;

import com.farm.auth.server.entity.ClientService;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ClientServiceMapper.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:12:02 <br />
 * 最后修改: 2018-09-04 10:12:02 <br />
 * 修改历史: <br />
 */
public interface ClientServiceMapper extends Mapper<ClientService> {
	
	void deleteByServiceId(int id);
}
