package com.farm.auth.server.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.auth.server.configuration.KeyConfiguration;
import com.farm.auth.server.service.AuthClientService;
import com.farm.common.msg.ObjectRestResponse;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ClientController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 14:05:00 <br />
 * 最后修改: 2018-09-04 14:05:00 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("client")
public class ClientController {
	private final static Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
    private AuthClientService authClientService;
	
    @Autowired
    private KeyConfiguration keyConfiguration;
    
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ObjectRestResponse<String> getAccessToken(String clientId, String secret) throws Exception {
    	logger.info("POST token: clientId:{}, secret:{}", clientId, secret);
        return new ObjectRestResponse<String>().data(authClientService.apply(clientId, secret));
    }

    /**
     * 获取授权的客户端列表
     * @param serviceId
     * @param secret
     * @return
     */
    @RequestMapping(value = "/myClient")
    public ObjectRestResponse<List<String>> getAllowedClient(String serviceId, String secret) {
    	logger.info("myClient: serviceId:{}, secret:{}", serviceId, secret);
    	
        return new ObjectRestResponse<List<String>>().data(authClientService.getAllowedClient(serviceId, secret));
    }

    @RequestMapping(value = "/servicePubKey",method = RequestMethod.POST)
    public ObjectRestResponse<byte[]> getServicePublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret) throws Exception {
    	logger.info("POST servicePubKey: clientId:{}, secret:{}", clientId, secret);
    	
        authClientService.validate(clientId, secret);
        return new ObjectRestResponse<byte[]>().data(keyConfiguration.getServicePubKey());
    }

    @RequestMapping(value = "/userPubKey",method = RequestMethod.POST)
    public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret) throws Exception {
    	logger.info("POST userPubKey: clientId:{}, secret:{}", clientId, secret);
    	
        authClientService.validate(clientId, secret);
        return new ObjectRestResponse<byte[]>().data(keyConfiguration.getUserPubKey());
    }
}