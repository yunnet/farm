package com.farm.blog.admin.configurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: Swagger2Configuration.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-10-29 18:13:20 <br />
 * 最后修改: 2018-10-29 18:13:20 <br />
 * 修改历史: <br />
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	@Value("${swagger2.base-package}")
    private String basePackage;

    @Value("${swagger2.title}")
    private String title;

    @Value("${swagger2.description}")
    private String description;

    @Value("${swagger2.terms-of-service-url}")
    private String termsOfServiceUrl;

    @Value("${swagger2.version}")
    private String version;

    @Value("${swagger2.contact.name}")
    private String contactName;

    @Value("${swagger2.contact.url}")
    private String contactUrl;

    @Value("${swagger2.contact.email}")
    private String contactEmail;

    @Value("${swagger2.license}")
    private String license;

    @Value("${swagger2.license-url}")
    private String licenseUrl;
	

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any())
				.build()
				;
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.termsOfServiceUrl(termsOfServiceUrl)
				.version(version)
				.contact(new Contact(contactName, contactUrl, contactEmail))
                .license(license)
                .licenseUrl(licenseUrl)
				.build();
	}

}
