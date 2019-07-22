package com.farm.cache.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.farm.cache.constants.CacheScope;
import com.farm.cache.parser.ICacheResultParser;
import com.farm.cache.parser.IKeyGenerator;
import com.farm.cache.parser.impl.DefaultKeyGenerator;
import com.farm.cache.parser.impl.DefaultResultParser;


/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: Cache.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 13:51:16 <br />
 * 最后修改: 2018-09-05 13:51:16 <br />
 * 修改历史: <br />
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Cache {
	
	/**
     * 缓存key menu_{0.id}{1}_type
     *
     * @return
     * @author Ace
     * @date 2017年5月3日
     */
    public String key() default "";

    /**
     * 作用域
     *
     * @return
     * @author Ace
     * @date 2017年5月3日
     */
    public CacheScope scope() default CacheScope.application;

    /**
     * 过期时间
     *
     * @return
     * @author Ace
     * @date 2017年5月3日
     */
    public int expire() default 720;

    /**
     * 描述
     *
     * @return
     * @author Ace
     * @date 2017年5月3日
     */
    public String desc() default "";

    /**
     * 返回类型
     *
     * @return
     * @author Ace
     * @date 2017年5月4日
     */
    public Class[] result() default Object.class;

    /**
     * 返回结果解析类
     *
     * @return
     */
    public Class<? extends ICacheResultParser> parser() default DefaultResultParser.class;

    /**
     * 键值解析类
     *
     * @return
     */
    public Class<? extends IKeyGenerator> generator() default DefaultKeyGenerator.class;

}
