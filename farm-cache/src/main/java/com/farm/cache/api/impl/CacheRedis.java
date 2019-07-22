package com.farm.cache.api.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.farm.cache.api.CacheAPI;
import com.farm.cache.config.RedisConfig;
import com.farm.cache.constants.CacheConstants;
import com.farm.cache.entity.CacheBean;
import com.farm.cache.service.IRedisService;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: CacheRedis.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 11:56:30 <br />
 * 最后修改: 2018-09-05 11:56:30 <br />
 * 修改历史: <br />
 */
@Service
public class CacheRedis implements CacheAPI{
	@Autowired
    private RedisConfig redisConfig;

    @Autowired
    private IRedisService redisCacheService;

	
	@Override
	public String get(String key) {
		if (!isEnabled())
            return null;
		
        if(StringUtils.isBlank(key)){
            return null;
        }
        
        CacheBean cache = getCacheBean(key);
        if (cache != null) {
            if (cache.getExpireTime().getTime() > new Date().getTime()) {
                return redisCacheService.get(cache.getKey());
            } else {
                redisCacheService.del(addSys(key));
                redisCacheService.del(cache.getKey());
            }
        }
        return null;
	}
	
	private CacheBean getCacheBean(String key) {
        key = this.addSys(key);
        CacheBean cache = null;
        try {
            cache = JSON.parseObject(redisCacheService.get(key), CacheBean.class);
        } catch (Exception e) {
            cache = new CacheBean();
            cache.setKey(key);
            cache.setExpireTime(redisCacheService.getExpireDate(key));
        }
        return cache;
    }

	@Override
	public void set(String key, Object value, int expireMin) {
		set(key, value, expireMin, "");
	}

	@Override
	public void set(String key, Object value, int expireMin, String desc) {
		if (!isEnabled())
			return;
		
		if (StringUtils.isBlank(key) || value == null || StringUtils.isBlank(value.toString()))
            return;
		
        String realValue = "";
        if (value instanceof String) {
            realValue = value.toString();
        } else {
            realValue = JSON.toJSONString(value, false);
        }
        
        String realKey = CacheConstants.PRE + addSys(key);
        Date time = new DateTime(redisCacheService.getExpireDate(realKey)).plusMinutes(expireMin).toDate();
        CacheBean cache = new CacheBean(realKey, desc, time);
        String result = JSON.toJSONString(cache, false);
        
        redisCacheService.set(addSys(key), result, expireMin * 60);
        redisCacheService.set(realKey, realValue, expireMin * 60);
	}

	@Override
	public Long remove(String key) {
		if (!isEnabled())
            return 0L;
		
        if(StringUtils.isBlank(key))
            return 0L;
        
        try {
            CacheBean cache = getCacheBean(key);
            if (cache != null) {
                redisCacheService.del(addSys(key));
                redisCacheService.del(cache.getKey());
            }
        } catch (Exception e) {
            return 0L;
        }
        return 1L;
	}

	@Override
	public Long remove(String... keys) {
		if (!isEnabled())
            return null;
		
        try {
            for (int i = 0; i < keys.length; i++) {
                remove(keys[i]);
            }
        } catch (Exception e) {
            return 0L;
        }
        return 1l;
	}

	@Override
	public Long removeByPre(String pre) {
		if (!isEnabled())
            return 0L;
		
        if(StringUtils.isBlank(pre))
            return 0L;
        
        try {
            Set<String> result = redisCacheService.getByPre(addSys(pre));
            List<String> list = new ArrayList<>();
            for (String key : result) {
                CacheBean cache = getCacheBean(key);
                list.add(cache.getKey());
            }
            redisCacheService.del(list.toArray(new String[]{}));
            redisCacheService.delPre(addSys(pre));
        } catch (Exception e) {
            return 0L;
        }
        return 1L;
	}

	@Override
	public List<CacheBean> getCacheBeanByPre(String pre) {
		if(StringUtils.isBlank(pre)){
            return new ArrayList<>();
        }
		
        Set<String> result = redisCacheService.getByPre(pre);
        Iterator<String> it = result.iterator();
        List<CacheBean> caches = new ArrayList<>();
        String key = "";
        CacheBean cache = null;
        while (it.hasNext()) {
            key = it.next();
            try {
                cache = JSON.parseObject(redisCacheService.get(key), CacheBean.class);
            } catch (Exception e) {
                cache = new CacheBean();
                cache.setKey(key);
                cache.setExpireTime(redisCacheService.getExpireDate(key));
            }
            cache.setKey(key);
            caches.add(cache);
        }
        return caches;
	}

	@Override
	public List<CacheBean> listAll() {
		Set<String> result = redisCacheService.getByPre(addSys(""));
        List<CacheBean> caches = new ArrayList<>();
        if (result == null)
            return caches;
        
        Iterator<String> it = result.iterator();
        String key = "";
        CacheBean cache = null;
        while (it.hasNext()) {
            cache = null;
            key = it.next();
            try {
                cache = JSON.parseObject(redisCacheService.get(key), CacheBean.class);
            } catch (Exception e) {
                cache = new CacheBean();
                cache.setKey(key);
                cache.setExpireTime(redisCacheService.getExpireDate(key));
            }
            
            if (cache == null)
                continue;
            
            cache.setKey(key);
            caches.add(cache);
        }
        return caches;
	}

	@Override
	public boolean isEnabled() {
		return Boolean.parseBoolean(redisConfig.getEnable());
	}

	@Override
	public String addSys(String key) {
		String result = key;
        String sys = redisConfig.getSysName();
        if (key.startsWith(sys))
            result = key;
        else
            result = sys + ":" + key;
        return result;
	}
}