package com.farm.auth.server.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.farm.auth.server.biz.ClientBiz;
import com.farm.auth.server.entity.Client;
import com.farm.auth.server.entity.ClientService;
import com.farm.common.msg.ObjectRestResponse;
import com.farm.common.rest.BaseController;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ServiceController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 14:07:26 <br />
 * 最后修改: 2018-09-04 14:07:26 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("service")
@SuppressWarnings("unchecked")
public class ServiceController extends BaseController<ClientBiz,Client>{
	
	@RequestMapping(value = "/{id}/client", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse<?> modifyUsers(@PathVariable int id, String clients){
        baseBiz.modifyClientServices(id, clients);
        return new ObjectRestResponse<Object>().rel(true);
    }

    @RequestMapping(value = "/{id}/client", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<ClientService> getUsers(@PathVariable int id){
        return new ObjectRestResponse<ClientService>().rel(true).data(baseBiz.getClientServices(id));
    }
}