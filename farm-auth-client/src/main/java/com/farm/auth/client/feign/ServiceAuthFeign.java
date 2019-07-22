package com.farm.auth.client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.common.msg.ObjectRestResponse;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: ServiceAuthFeign.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-04 18:06:37 <br />
 * 最后修改: 2018-09-04 18:06:37 <br />
 * 修改历史: <br />
 */
@FeignClient(value = "${auth.serviceId}", configuration = {})
public interface ServiceAuthFeign {
	@RequestMapping(value = "/client/myClient")
	public ObjectRestResponse<List<String>> getAllowedClient(@RequestParam("serviceId") String serviceId, @RequestParam("secret") String secret);

	@RequestMapping(value = "/client/token", method = RequestMethod.POST)
	public ObjectRestResponse<?> getAccessToken(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

	@RequestMapping(value = "/client/servicePubKey", method = RequestMethod.POST)
	public ObjectRestResponse<byte[]> getServicePublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

	@RequestMapping(value = "/client/userPubKey", method = RequestMethod.POST)
	public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);
}