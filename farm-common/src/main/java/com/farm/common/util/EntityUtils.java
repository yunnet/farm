package com.farm.common.util;

import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.farm.common.context.BaseContextHandler;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: EntityUtils.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 14:37:59 <br />
 * 最后修改: 2018-09-03 14:37:59 <br />
 * 修改历史: <br />
 */
public class EntityUtils {
	
	public static <T> void setCreateAndUpdateInfo(T t) {
		setCreateInfo(t);
		setUpdatedInfo(t);
	}

	/**
	 * @param t
	 */
	public static <T> void setCreateInfo(T t) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String hostIp = "";
		String name = "";
		String id = "";
		if(null != request) {
			hostIp = StringUtils.defaultIfBlank(request.getHeader("userHost"), NetUtil.getClientIp(request));
			name = StringUtils.trimToEmpty(request.getHeader("userName"));
			name = URLDecoder.decode(name);
			id = StringUtils.trimToEmpty(request.getHeader("userId"));
		}

		if (StringUtils.isBlank(name)) {
			name = BaseContextHandler.getUsername();
		}
		
		if (StringUtils.isBlank(id)) {
			id = BaseContextHandler.getUserID();
		}

		// 默认属性
		String[] fields = {"crtName", "crtUser", "crtHost", "crtTime"};
		Field field = ReflectionUtils.getAccessibleField(t, "crtTime");
		
		// 默认值
		Object [] value = null;
		if(field != null && field.getType().equals(Date.class)){
			value = new Object []{name, id, hostIp, new Date()};
		}
		// 填充默认属性值
		setDefaultValues(t, fields, value);
	}
	
	/**
	 * 快速将bean的updUser、updHost、updTime附上相关值
	 * @param t 实体bean
	 */
	public static <T> void setUpdatedInfo(T t) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String hostIp = "";
		String name = "";
		String id = "";
		if(request != null) {
			hostIp = StringUtils.defaultIfBlank(request.getHeader("userHost"), NetUtil.getClientIp(request));
			name = StringUtils.trimToEmpty(request.getHeader("userName"));
			name = URLDecoder.decode(name);
			id = StringUtils.trimToEmpty(request.getHeader("userId"));
		}

		if (StringUtils.isBlank(name)) {
			name = BaseContextHandler.getUsername();
		}
		
		if (StringUtils.isBlank(id)) {
			id = BaseContextHandler.getUserID();
		}

		// 默认属性
		String[] fields = {"updName", "updUser", "updHost", "updTime"};
		Field field = ReflectionUtils.getAccessibleField(t, "updTime");
		Object [] value = null;
		if(field != null && field.getType().equals(Date.class)){
			value = new Object []{name, id, hostIp, new Date()};
		}
		
		// 填充默认属性值
		setDefaultValues(t, fields, value);
	}
	
	/**
	 * 依据对象的属性数组和值数组对对象的属性进行赋值
	 * 
	 * @param t 对象
	 * @param fields 属性数组
	 * @param value 值数组
	 * @author 王浩彬
	 */
	private static <T> void setDefaultValues(T t, String[] fields, Object[] value) {
		for(int i = 0, num = fields.length; i < num; i++){
			String field = fields[i];
			if(ReflectionUtils.hasField(t, field)){
				ReflectionUtils.invokeSetter(t, field, value[i]);
			}
		}
	}
	
	/**
	 * 根据主键属性，判断主键是否值为空
	 * 
	 * @param entity
	 * @param field
	 * @return 主键为空，则返回false；主键有值，返回true
	 */
	public static <T> boolean isPKNotNull(T entity, String field){
		if(!ReflectionUtils.hasField(entity, field)) {
			return false;
		}
		
		Object value = ReflectionUtils.getFieldValue(entity, field);
		return value != null && !"".equals(value);
	}
}