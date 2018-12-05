package com.farm.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farm.common.handler.GlobalExceptionHandler;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: AuthConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 16:18:42 <br />
 * 最后修改: 2018-09-04 16:18:42 <br />
 * 修改历史: <br />
 */
@Configuration
public class AuthConfiguration {
	
	@Bean
    public GlobalExceptionHandler getGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
