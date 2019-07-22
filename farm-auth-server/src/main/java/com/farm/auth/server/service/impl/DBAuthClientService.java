package com.farm.auth.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.auth.server.bean.ClientInfo;
import com.farm.auth.server.entity.Client;
import com.farm.auth.server.mapper.ClientMapper;
import com.farm.auth.server.service.AuthClientService;
import com.farm.auth.server.util.client.ClientTokenUtil;
import com.farm.common.exception.auth.ClientInvalidException;
import com.farm.common.util.UUIDUtils;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: DBAuthClientService.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 13:04:50 <br />
 * 最后修改: 2018-09-04 13:04:50 <br />
 * 修改历史: <br />
 */
@Service
public class DBAuthClientService implements AuthClientService {
	@Autowired
    private ClientMapper clientMapper;
	
    @Autowired
    private ClientTokenUtil clientTokenUtil;
    
    @Autowired
    private DiscoveryClient discovery;
        
    private ApplicationContext context;
    
    private static final List<String> EMPTY_ARRAY = new ArrayList<>();
    
    /**
     * 构造函数
     * @param context
     */
	public DBAuthClientService(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public String apply(String clientId, String secret) throws Exception {
		Client client = getClient(clientId, secret);
		IJWTInfo jwtInfo = new ClientInfo(client.getCode(), client.getName(), client.getIdStr());
		return clientTokenUtil.generateToken(jwtInfo);
	}
	
	/**
	 * 获取客户端对象
	 * @param clientId
	 * @param secret
	 * @return
	 */
	private Client getClient(String clientId, String secret) {
		Client client = getClient(clientId);      
        if(client == null || !client.getSecret().equals(secret)){
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
        return client;
    }
	
	/**
	 * 获取客户端对象
	 * @param clientId
	 * @return
	 */
	private Client getClient(String clientId) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        return client;
    }

	@Override
	public List<String> getAllowedClient(String clientId, String secret) {
		Client info = null;
		if(StringUtils.isBlank(secret)) {
		  info = this.getClient(clientId);
		} else {
		  info = this.getClient(clientId, secret);
		}
		
		if(null != info) {
			List<String> clients = clientMapper.selectAllowedClient(info.getIdStr());
			if(clients == null) {
				clients = EMPTY_ARRAY;
	        }
	        return clients;
		}else {
			return EMPTY_ARRAY;
		}
	}

	@Override
	public List<String> getAllowedClient(String clientId) {
		return this.getAllowedClient(clientId, null);
	}

	@Override
	@Scheduled(cron = "0 0/1 * * * ?")
	public void registryClient() {
		 // 自动注册节点
        discovery.getServices().forEach((name) ->{
            Client client = new Client();
            client.setName(name);
            client.setCode(name);
            
            Client dbClient = clientMapper.selectOne(client);
            if(null == dbClient) {
                client.setSecret(UUIDUtils.generateShortUuid());
                clientMapper.insert(client);
            }
        });
	}

	@Override
	public void validate(String clientId, String secret) throws Exception {
		Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        
        if(client == null || !client.getSecret().equals(secret)){
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
	}
}