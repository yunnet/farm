package com.farm.common.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: Query.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:24:38 <br />
 * 最后修改: 2018-09-03 15:24:38 <br />
 * 修改历史: <br />
 */
public class Query extends LinkedHashMap<String, Object>{
	private static final long serialVersionUID = 7515910135767538000L;

	/**
	 * 当前页码
	 */
	private int page = 1;
	
	/**
	 * 每页条数
	 */
	private int limit = 10;
	
	/**
	 * 构造函数
	 * @param params
	 */
	public Query(Map<String, Object> params) {
		this.putAll(params);
		//分页参数
        if(params.get("page")!=null) {
            this.page = Integer.parseInt(params.get("page").toString());
        }
        if(params.get("limit")!=null) {
            this.limit = Integer.parseInt(params.get("limit").toString());
        }
        this.remove("page");
        this.remove("limit");
	}

	/**
	 * 获取 
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 获取 
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * 设置 
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 设置 
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

}
