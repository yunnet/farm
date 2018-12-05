package com.farm.common.msg;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: ObjectRestResponse.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-03 16:00:44 <br />
 * 最后修改: 2018-09-03 16:00:44 <br />
 * 修改历史: <br />
 * 
 * @param <T>
 */
public class ObjectRestResponse<T> extends BaseResponse {
	
	/**
	 * 回复数据
	 */
	private T data;
	
	/**
	 * 是否需要回复
	 */
	private boolean rel;
	
	public ObjectRestResponse rel(boolean rel) {
		this.setRel(rel);
		return this;
	}
	
	public ObjectRestResponse data(T t) {
		this.setData(t);
		return this;
	}

	/**
	 * 获取
	 * 
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * 获取
	 * 
	 * @return the rel
	 */
	public boolean isRel() {
		return rel;
	}

	/**
	 * 设置
	 * 
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 设置
	 * 
	 * @param rel the rel to set
	 */
	public void setRel(boolean rel) {
		this.rel = rel;
	}
}