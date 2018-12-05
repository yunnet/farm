package com.farm.common.msg;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: BaseResponse.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:28:00 <br />
 * 最后修改: 2018-09-03 15:28:00 <br />
 * 修改历史: <br />
 */
public class BaseResponse {
	
	private int status = 200;
	
    private String message;
    
    /**
	 * 构造函数
	 */
	public BaseResponse() {
		
	}
    
    /**
     * 构造函数
     * @param status
     * @param message
     */
	public BaseResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * 获取 
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 获取 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置 
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 设置 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}