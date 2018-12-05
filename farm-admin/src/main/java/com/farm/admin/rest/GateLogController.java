package com.farm.admin.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farm.admin.biz.GateLogBiz;
import com.farm.admin.entity.GateLog;
import com.farm.common.rest.BaseController;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: GateLogController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 15:24:01 <br />
 * 最后修改: 2018-09-05 15:24:01 <br />
 * 修改历史: <br />
 */
@Controller
@RequestMapping("gateLog")
public class GateLogController extends BaseController<GateLogBiz,GateLog> {

}
