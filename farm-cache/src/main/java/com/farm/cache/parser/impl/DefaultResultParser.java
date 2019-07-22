package com.farm.cache.parser.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.farm.cache.parser.ICacheResultParser;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: DefaultResultParser.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:08:58 <br />
 * 最后修改: 2018-09-05 14:08:58 <br />
 * 修改历史: <br />
 */
public class DefaultResultParser implements ICacheResultParser {

	@Override
	public Object parse(String value, Type type, Class<?>... origins) {
		Object result = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (((Class) rawType).isAssignableFrom(List.class)) {
                result = JSON.parseArray(value, (Class) parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (origins == null) {
            result = JSON.parseObject(value, (Class) type);
        } else {
            result = JSON.parseObject(value, origins[0]);
        }
        return result;
	}
}