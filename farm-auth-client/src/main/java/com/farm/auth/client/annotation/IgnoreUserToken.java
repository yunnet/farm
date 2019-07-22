package com.farm.auth.client.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: IgnoreUserToken.java  <br />
 * 说        明: 忽略用户鉴权 <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 17:59:01 <br />
 * 最后修改: 2018-09-04 17:59:01 <br />
 * 修改历史: <br />
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface IgnoreUserToken {

}
