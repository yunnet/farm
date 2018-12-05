package com.farm.auth.server.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.farm.auth.server.configuration.ClientConfiguration;
import com.farm.auth.server.service.AuthClientService;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: ClientTokenInterceptor.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-04 11:57:59 <br />
 * 最后修改: 2018-09-04 11:57:59 <br />
 * 修改历史: <br />
 */
public class ClientTokenInterceptor implements RequestInterceptor {
	private final static Logger logger = LoggerFactory.getLogger(ClientTokenInterceptor.class);

	@Autowired
	private ClientConfiguration clientConfiguration;
	
	@Autowired
	private AuthClientService authClientService;

	@Override
	public void apply(RequestTemplate template) {
		try {
			template.header(clientConfiguration.getClientTokenHeader(), authClientService.apply(clientConfiguration.getClientId(), clientConfiguration.getClientSecret()));
        } catch (Exception e) {
        	logger.error("apply err: ", e);
        }
	}
}