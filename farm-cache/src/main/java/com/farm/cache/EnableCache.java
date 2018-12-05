package com.farm.cache;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: EnableCache.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 11:35:10 <br />
 * 最后修改: 2018-09-05 11:35:10 <br />
 * 修改历史: <br />
 */
@Target({TYPE})
@Retention(RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableCache {
	
}
