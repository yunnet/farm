package com.farm.cache.config;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.farm.cache.utils.PropertiesLoaderUtils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: RedisConfig.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 12:39:12 <br />
 * 最后修改: 2018-09-05 12:39:12 <br />
 * 修改历史: <br />
 */
@Configuration
public class RedisConfig {
	@Autowired
    private Environment env;
    
    private JedisPool pool;
    private String maxActive;
    private String maxIdle;
    private String maxWait;
    private String host;
    private String password;
    private String timeout;
    private String database;
    private String port;
    private String enable;
    private String sysName;
    
    @PostConstruct
    public void init(){
        PropertiesLoaderUtils prop = new PropertiesLoaderUtils("application.properties");
        host = prop.getProperty("redis.host");
        if(StringUtils.isBlank(host)){
            host = env.getProperty("redis.host");
            maxActive = env.getProperty("redis.pool.maxActive");
            maxIdle  = env.getProperty("redis.pool.maxIdle");
            maxWait = env.getProperty("redis.pool.maxWait");
            password = env.getProperty("redis.password");
            timeout = env.getProperty("redis.timeout");
            database = env.getProperty("redis.database");
            port = env.getProperty("redis.port");
            sysName = env.getProperty("redis.sysName");
            enable = env.getProperty("redis.enable");
        } else{
            maxActive = prop.getProperty("redis.pool.maxActive");
            maxIdle  = prop.getProperty("redis.pool.maxIdle");
            maxWait = prop.getProperty("redis.pool.maxWait");
            password = prop.getProperty("redis.password");
            timeout = prop.getProperty("redis.timeout");
            database = prop.getProperty("redis.database");
            port = prop.getProperty("redis.port");
            sysName = prop.getProperty("redis.sysName");
            enable = prop.getProperty("redis.enable");
        }
    }
    
    @Bean
    public JedisPoolConfig constructJedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        
        // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(Integer.parseInt(maxActive));
        
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(Integer.parseInt(maxIdle));
        
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(Integer.parseInt(maxWait));
        
        config.setTestOnBorrow(true);

        return config;
    }
    
    @Bean(name = "pool")
    public JedisPool constructJedisPool() {
        String ip = this.host;
        int port = Integer.parseInt(this.port);
        String password = this.password;
        int timeout = Integer.parseInt(this.timeout);
        int database = Integer.parseInt(this.database);
        if (null == pool) {
            if (StringUtils.isBlank(password)) {
                pool = new JedisPool(constructJedisPoolConfig(), ip, port, timeout);
            } else {
                pool = new JedisPool(constructJedisPoolConfig(), ip, port, timeout, password, database);
            }
        }
        return pool;
    }

	/**
	 * 获取 
	 * @return the env
	 */
	public Environment getEnv() {
		return env;
	}

	/**
	 * 设置 
	 * @param env the env to set
	 */
	public void setEnv(Environment env) {
		this.env = env;
	}

	/**
	 * 获取 
	 * @return the pool
	 */
	public JedisPool getPool() {
		return pool;
	}

	/**
	 * 设置 
	 * @param pool the pool to set
	 */
	public void setPool(JedisPool pool) {
		this.pool = pool;
	}

	/**
	 * 获取 
	 * @return the maxActive
	 */
	public String getMaxActive() {
		return maxActive;
	}

	/**
	 * 设置 
	 * @param maxActive the maxActive to set
	 */
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	/**
	 * 获取 
	 * @return the maxIdle
	 */
	public String getMaxIdle() {
		return maxIdle;
	}

	/**
	 * 设置 
	 * @param maxIdle the maxIdle to set
	 */
	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}

	/**
	 * 获取 
	 * @return the maxWait
	 */
	public String getMaxWait() {
		return maxWait;
	}

	/**
	 * 设置 
	 * @param maxWait the maxWait to set
	 */
	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}

	/**
	 * 获取 
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 设置 
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 获取 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取 
	 * @return the timeout
	 */
	public String getTimeout() {
		return timeout;
	}

	/**
	 * 设置 
	 * @param timeout the timeout to set
	 */
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	/**
	 * 获取 
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * 设置 
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * 获取 
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * 设置 
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * 获取 
	 * @return the enable
	 */
	public String getEnable() {
		return enable;
	}

	/**
	 * 设置 
	 * @param enable the enable to set
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}

	/**
	 * 获取 
	 * @return the sysName
	 */
	public String getSysName() {
		return sysName;
	}

	/**
	 * 设置 
	 * @param sysName the sysName to set
	 */
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
}