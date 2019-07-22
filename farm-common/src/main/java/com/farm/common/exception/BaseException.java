package com.farm.common.exception;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: BaseException.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:45:53 <br />
 * 最后修改: 2018-09-03 15:45:53 <br />
 * 修改历史: <br />
 */
public class BaseException extends RuntimeException{
	private static final long serialVersionUID = -6179612005368099041L;
	
	private int status = 200;
	
	public BaseException() {
		
	}
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(String message, int status) {
		super(message);
		this.status = status;
	}
	
	public BaseException(Throwable cause) {
        super(cause);
    }
	
	public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

	/**
	 * 获取 
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 设置 
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}