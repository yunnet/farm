package com.farm.cache.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.cache.service.ICacheManager;
import com.farm.cache.utils.TreeUtils;
import com.farm.cache.vo.CacheTree;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: CacheRest.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:33:22 <br />
 * 最后修改: 2018-09-05 14:33:22 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("cache")
public class CacheRest {
	@Autowired
	private ICacheManager cacheManager;
	
	@RequestMapping("/list")
	public List<CacheTree> listAll() {
		return TreeUtils.buildTree(cacheManager.getAll());
	}
	
	@RequestMapping(path = "/pre/{pre:.*}", method = RequestMethod.GET)
	public List<CacheTree> listPre(@PathVariable("pre") String pre){
		return TreeUtils.buildTree(cacheManager.getByPre(pre));
	}
	
	@RequestMapping(path = "/{key:.*}", method = RequestMethod.GET)
	public String get(@PathVariable("key") String key) {
		return cacheManager.get(key);
	}
	
	@RequestMapping(path = "/remove", method = {RequestMethod.DELETE})
	public void removeAll() {
		cacheManager.removeAll();
	}
	
	@RequestMapping(path = "/pre/{pre:.*}", method = {RequestMethod.DELETE})
    public void removePre(@PathVariable("pre") String pre) {
        cacheManager.removeByPre(pre);
    }

    @RequestMapping(path = "/{key:.*}", method = RequestMethod.DELETE)
    public void removeKey(@PathVariable("key") String key) {
        cacheManager.remove(key);
    }

    @RequestMapping(path = "/{key:.*}", method = RequestMethod.PUT)
    public void updateTime(@PathVariable("key") String key, int hour) {
        cacheManager.update(key, hour);
    }

    @RequestMapping("")
    public String index() {
        return "/static/cache/index.html";
    }
}