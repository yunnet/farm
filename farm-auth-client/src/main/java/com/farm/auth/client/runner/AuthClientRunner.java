package com.farm.auth.client.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

import com.farm.auth.client.configuration.ServiceAuthConfig;
import com.farm.auth.client.configuration.UserAuthConfig;
import com.farm.auth.client.feign.ServiceAuthFeign;
import com.farm.common.msg.BaseResponse;
import com.farm.common.msg.ObjectRestResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: AuthClientRunner.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:56:44 <br />
 * 最后修改: 2018-09-04 17:56:44 <br />
 * 修改历史: <br />
 */
@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner {
	@Autowired
    private ServiceAuthConfig serviceAuthConfig;
	
    @Autowired
    private UserAuthConfig userAuthConfig;
    
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;
    

	@Override
	public void run(String... args) throws Exception {
		log.info("初始化加载用户pubKey");
        try {
            refreshUserPubKey();
        }catch(Exception e){
            log.error("初始化加载用户pubKey失败,1分钟后自动重试!",e);
        }
        
        log.info("初始化加载客户pubKey");
        try {
            refreshServicePubKey();
        }catch(Exception e){
            log.error("初始化加载客户pubKey失败,1分钟后自动重试!",e);
        }
	}
	
	/**
	 * 获取User PubKey
	 */
	@Scheduled(cron = "0 0/1 * * * ?")
	@SuppressWarnings("unchecked")
    public void refreshUserPubKey(){
        BaseResponse resp = serviceAuthFeign.getUserPublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
            this.userAuthConfig.setPubKeyByte(userResponse.getData());
        }
    }
    
	/**
	 * 获取Service PubKey
	 */
    @Scheduled(cron = "0 0/1 * * * ?")
    @SuppressWarnings("unchecked")
    public void refreshServicePubKey(){
        BaseResponse resp = serviceAuthFeign.getServicePublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
            this.serviceAuthConfig.setPubKeyByte(userResponse.getData());
        }
    }
}