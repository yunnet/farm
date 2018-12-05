package com.farm.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.farm.api.vo.log.LogInfo;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ILogService.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 10:27:16 <br />
 * 最后修改: 2018-09-12 10:27:16 <br />
 * 修改历史: <br />
 */
@FeignClient("farm-admin")
public interface ILogService {
	
	@RequestMapping(value="/api/log/save", method = RequestMethod.POST)
	public void saveLog(LogInfo info);
}