package com.farm.auth.server.util.user;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: JwtAuthenticationRequest.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:31:58 <br />
 * 最后修改: 2018-09-04 10:31:58 <br />
 * 修改历史: <br />
 */
public class JwtAuthenticationRequest {
	
	private String username;
	
    private String password;
    
    /**
	 * 构造函数
	 */
	public JwtAuthenticationRequest() {
		
	}
	
	public JwtAuthenticationRequest(String username, String password) {
		this.username = username;
        this.password = password;
	}

	/**
	 * 获取 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	
	

}
