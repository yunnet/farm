package com.farm.cache.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: CacheWebConfig.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:28:05 <br />
 * 最后修改: 2018-09-05 14:28:05 <br />
 * 修改历史: <br />
 */
@Configuration("cacheWebConfig")
public class CacheWebConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/cache/**")
                .addResourceLocations("classpath:/META-INF/static/");
	}
}
