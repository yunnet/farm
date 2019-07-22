package com.farm.admin.rpc;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.farm.admin.biz.GateLogBiz;
import com.farm.admin.entity.GateLog;
import com.farm.api.vo.log.LogInfo;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: LogRest.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 16:11:34 <br />
 * 最后修改: 2018-09-05 16:11:34 <br />
 * 修改历史: <br />
 */
@RequestMapping("api")
@RestController
public class LogRest {
	@Autowired
	private GateLogBiz gateLogBiz;

	@RequestMapping(value = "/log/save", method = RequestMethod.POST)
	public @ResponseBody void saveLog(@RequestBody LogInfo info) {
		GateLog log = new GateLog();
		BeanUtils.copyProperties(info, log);
		gateLogBiz.insertSelective(log);
	}
}