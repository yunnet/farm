package com.farm.common.msg;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ListRestResponse.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:29:34 <br />
 * 最后修改: 2018-09-03 15:29:34 <br />
 * 修改历史: <br />
 * @param <T>
 */
public class ListRestResponse<T> {
	
	private String msg;
	
	private T result;
    
	private long count;
    
    public ListRestResponse<T> count(long count){
    	this.setCount(count);
    	return this;
    }
    
    public ListRestResponse<T> result(T t){
    	this.setResult(t);
    	return this;
    }
    
    public ListRestResponse<T> msg(String msg){
    	this.setMsg(msg);
    	return this;
    }

	/**
	 * 获取 
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	
	/**
	 * 设置 
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取 
	 * @return the result
	 */
	public T getResult() {
		return result;
	}
	
	/**
	 * 设置 
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * 获取 
	 * @return the count
	 */
	public long getCount() {
		return count;
	}
	
	/**
	 * 设置 
	 * @param count the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}
}