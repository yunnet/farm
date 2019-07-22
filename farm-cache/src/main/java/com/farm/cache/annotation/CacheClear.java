package com.farm.cache.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.farm.cache.parser.IKeyGenerator;
import com.farm.cache.parser.impl.DefaultKeyGenerator;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: CacheClear.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 14:19:16 <br />
 * 最后修改: 2018-09-05 14:19:16 <br />
 * 修改历史: <br />
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD})
public @interface CacheClear {

	/**
	 * 缓存key的前缀
	 *
	 * @return
	 */
	public String pre() default "";

	/**
	 * 缓存key
	 *
	 * @return
	 */
	public String key() default "";

	/**
	 * 缓存keys
	 *
	 * @return
	 */
	public String[] keys() default "";

	/**
	 * 键值解析类
	 *
	 * @return
	 */
	public Class<? extends IKeyGenerator> generator() default DefaultKeyGenerator.class;
}
