package com.farm.cache.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: PropertiesLoaderUtils.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 12:48:58 <br />
 * 最后修改: 2018-09-05 12:48:58 <br />
 * 修改历史: <br />
 */
public class PropertiesLoaderUtils {
	private static Logger logger = LoggerFactory.getLogger(PropertiesLoaderUtils.class);
	
	private final static ResourceLoader resourceLoader = new DefaultResourceLoader();

	private final Properties properties;
	
	/**
	 * 构造函数
	 * @param resourcesPaths
	 */
	public PropertiesLoaderUtils(String... resourcesPaths) {
		properties = loadProperties(resourcesPaths);
	}
	
	/**
	 * 载入多个文件, 文件路径使用Spring Resource格式.
	 */
	private Properties loadProperties(String... resourcesPaths) {
		Properties props = new Properties();

		for (String location : resourcesPaths) {

			//logger.debug("Loading properties file from:" + location);
			InputStream is = null;
			try {
				Resource resource = resourceLoader.getResource(location);
				is = resource.getInputStream();
				props.load(is);
			} catch (IOException ex) {
				logger.info("Could not load properties from path:" + location + ", " + ex.getMessage());
			} finally {
				if(is!=null){
					try {
						is.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return props;
	}

	public Properties getProperties() {
		return properties;
	}
	
	/**
	 * 取出Property，但以System的Property优先,取不到返回空字符串.
	 * @param key
	 * @return
	 */
	private String getValue(String key) {
		String systemProperty = System.getProperty(key);
		if (systemProperty != null) {
			return systemProperty;
		}
		if (properties.containsKey(key)) {
	        return properties.getProperty(key);
	    }
	    return "";
	}
	
	/**
	 * 取出String类型的Property，但以System的Property优先,如果都为Null则抛出异常.
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return value;
	}

	/**
	 *  取出String类型的Property，但以System的Property优先.如果都为Null则返回Default值.
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getProperty(String key, String defaultValue) {
		String value = getValue(key);
		return value != null ? value : defaultValue;
	}
	
	/**
	 * 取出Integer类型的Property，但以System的Property优先.如果都为Null或内容错误则抛出异常.
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Integer.valueOf(value);
	}

	/**
	 * 取出Integer类型的Property，但以System的Property优先.如果都为Null则返回Default值，如果内容错误则抛出异常
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Integer getInteger(String key, Integer defaultValue) {
		String value = getValue(key);
		return value != null ? Integer.valueOf(value) : defaultValue;
	}

	/**
	 * 取出Double类型的Property，但以System的Property优先.如果都为Null或内容错误则抛出异常.
	 * @param key
	 * @return
	 */
	public Double getDouble(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Double.valueOf(value);
	}

	/**
	 * 取出Double类型的Property，但以System的Property优先.如果都为Null则返回Default值，如果内容错误则抛出异常
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Double getDouble(String key, Integer defaultValue) {
		String value = getValue(key);
		return value != null ? Double.valueOf(value) : defaultValue;
	}

	/**
	 * 取出Boolean类型的Property，但以System的Property优先.如果都为Null抛出异常,如果内容不是true/false则返回false.
	 * @param key
	 * @return
	 */
	public Boolean getBoolean(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return Boolean.valueOf(value);
	}

	/**
	 * 取出Boolean类型的Property，但以System的Property优先.如果都为Null则返回Default值,如果内容不为true/false则返回false.
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Boolean getBoolean(String key, boolean defaultValue) {
		String value = getValue(key);
		return value != null ? Boolean.valueOf(value) : defaultValue;
	}
}