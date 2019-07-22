package com.farm.auth.client.interceptor;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.farm.auth.client.configuration.ServiceAuthConfig;
import com.farm.auth.client.configuration.UserAuthConfig;
import com.farm.auth.client.jwt.ServiceAuthUtil;
import com.farm.auth.common.constatns.CommonConstants;
import com.farm.common.context.BaseContextHandler;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: OkHttpTokenInterceptor.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:54:22 <br />
 * 最后修改: 2018-09-04 17:54:22 <br />
 * 修改历史: <br />
 */
@Component
@Slf4j
public class OkHttpTokenInterceptor implements Interceptor{
	@Autowired
    @Lazy
    private ServiceAuthUtil serviceAuthUtil;
	
    @Autowired
    @Lazy
    private ServiceAuthConfig serviceAuthConfig;
    
    @Autowired
    @Lazy
    private UserAuthConfig userAuthConfig;

	@Override
	public Response intercept(Chain chain) throws IOException {
		System.err.println(":::::::intercept:" + chain.request().url().toString());
		
		String usertoken = BaseContextHandler.getToken();
		Request newRequest = null;
		if (chain.request().url().toString().contains("client/token")) {
            newRequest = chain.request()
                    .newBuilder()
                    .header(userAuthConfig.getTokenHeader(), usertoken)
                    .build();
        } else {
        	String servicetoken = serviceAuthUtil.getClientToken();
        	if(StringUtils.isBlank(servicetoken)) {
        		log.error("intercept err: servicetoken is null.");
        		return null;
        	}
        	
            newRequest = chain.request()
                    .newBuilder()
                    .header(userAuthConfig.getTokenHeader(), usertoken)        //Authorization
                    .header(serviceAuthConfig.getTokenHeader(), servicetoken)  //x-client-token
                    .build();
        }
		
		Response response = chain.proceed(newRequest);
		//403
        if (HttpStatus.FORBIDDEN.value() == response.code()) {
            if (response.body().string().contains(String.valueOf(CommonConstants.EX_CLIENT_INVALID_CODE))) {
                log.info("Client Token Expire, Retry to request...");
                
                serviceAuthUtil.refreshClientToken();
                newRequest = chain.request()
                        .newBuilder()
                        .header(userAuthConfig.getTokenHeader(), usertoken)
                        .header(serviceAuthConfig.getTokenHeader(), serviceAuthUtil.getClientToken())
                        .build();
                response = chain.proceed(newRequest);
            }
        }
        return response;		
	}
}