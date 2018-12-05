package com.farm.cache.parser;

import java.lang.reflect.Type;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ICacheResultParser.java  <br />
 * 说        明: cache结果解析 <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 13:47:46 <br />
 * 最后修改: 2018-09-05 13:47:46 <br />
 * 修改历史: <br />
 */
public interface ICacheResultParser {
	
	/**
	 * 解析结果
	 * @param value
	 * @param returnType
	 * @param origins
	 * @return
	 */
	public Object parse(String value, Type returnType, Class<?>... origins);
}
