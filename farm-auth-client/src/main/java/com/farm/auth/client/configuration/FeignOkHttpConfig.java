package com.farm.auth.client.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farm.auth.client.interceptor.OkHttpTokenInterceptor;

import feign.Feign;
import okhttp3.ConnectionPool;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: FeignOkHttpConfig.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:12:55 <br />
 * 最后修改: 2018-09-04 17:12:55 <br />
 * 修改历史: <br />
 */
@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
@ConditionalOnClass(Feign.class)
public class FeignOkHttpConfig {
	@Autowired
	private OkHttpTokenInterceptor okHttpLoggingInterceptor;
	
	private int feignOkHttpReadTimeout = 60;
	private int feignConnectTimeout = 60;
	private int feignWriteTimeout = 120;
	
	@Bean
	public okhttp3.OkHttpClient okHttpClient() {
		return new okhttp3.OkHttpClient.Builder()
				.readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
				.connectTimeout(feignConnectTimeout, TimeUnit.SECONDS)
				.writeTimeout(feignWriteTimeout, TimeUnit.SECONDS)
				.connectionPool(new ConnectionPool())
				.addInterceptor(okHttpLoggingInterceptor)
				.build();
	}
}