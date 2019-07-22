package com.farm.auth.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: UserConfiguration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 16:24:12 <br />
 * 最后修改: 2018-09-04 16:24:12 <br />
 * 修改历史: <br />
 */
@Configuration
@Data
public class UserConfiguration {
	
	@Value("${jwt.token-header}")
    private String userTokenHeader;
}
