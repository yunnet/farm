package com.farm.auth.common.jwt;

/**
 * 版权所有: 2018 ® iot Company <br />
 * 单元名称: JWTInfo.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-03 17:29:10 <br />
 * 最后修改: 2018-09-03 17:29:10 <br />
 * 修改历史: <br />
 */
public class JWTInfo implements IJWTInfo {
	
	private String userId;
	
	private String username;
	
	private String name;

	/**
	 * 构造函数
	 * @param username
	 * @param userId
	 * @param name
	 */
	public JWTInfo(String username, String userId, String name) {
		this.username = username;
		this.userId = userId;
		this.name = name;
	}

	@Override
	public String getUniqueName() {
		return username;
	}

	@Override
	public String getId() {
		return userId;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * 设置 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		JWTInfo jwtInfo = (JWTInfo) o;

		if (username != null ? !username.equals(jwtInfo.username) : jwtInfo.username != null) {
			return false;
		}
		return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;

	}

	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		return result;
	}
}