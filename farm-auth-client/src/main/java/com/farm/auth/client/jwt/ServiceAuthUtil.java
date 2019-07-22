package com.farm.auth.client.jwt;

import java.security.SignatureException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.farm.auth.client.configuration.ServiceAuthConfig;
import com.farm.auth.client.feign.ServiceAuthFeign;
import com.farm.auth.common.jwt.IJWTInfo;
import com.farm.auth.common.jwt.JWTHelper;
import com.farm.common.exception.auth.ClientTokenException;
import com.farm.common.msg.BaseResponse;
import com.farm.common.msg.ObjectRestResponse;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ServiceAuthUtil.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:55:33 <br />
 * 最后修改: 2018-09-04 17:55:33 <br />
 * 修改历史: <br />
 */
@Configuration
@Slf4j
@EnableScheduling
public class ServiceAuthUtil {
	@Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    private List<String> allowedClient;
    
    private String clientToken;

    public String getClientToken() {
        if (StringUtils.isBlank(this.clientToken)) {
            this.refreshClientToken();
        }
        return clientToken;
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }
    
    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new ClientTokenException("Client token expired!");
        } catch (SignatureException ex) {
            throw new ClientTokenException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new ClientTokenException("Client token is null or empty!");
        }
    }
    
    @Scheduled(cron = "0/30 * * * * ?")
    public void refreshAllowedClient() {
        log.debug("refresh allowedClient.....");
        BaseResponse resp = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            this.allowedClient = allowedClient.getData();
        }
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    public void refreshClientToken() {
        log.debug("refresh client token.....");
        BaseResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
			ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
            this.clientToken = clientToken.getData();
        }
    }
}