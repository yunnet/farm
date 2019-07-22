package com.farm.cache.service;

import java.util.List;

import com.farm.cache.entity.CacheBean;
import com.farm.cache.vo.CacheTree;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ICacheManager.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:35:05 <br />
 * 最后修改: 2018-09-05 14:35:05 <br />
 * 修改历史: <br />
 */
public interface ICacheManager {
	
	public void removeAll();

    public void remove(String key);

    public void remove(List<CacheBean> caches);

    public void removeByPre(String pre);

    public List<CacheTree> getAll();

    public List<CacheTree> getByPre(String pre);

    public void update(String key, int hour);

    public void update(List<CacheBean> caches, int hour);

    public String get(String key);
}