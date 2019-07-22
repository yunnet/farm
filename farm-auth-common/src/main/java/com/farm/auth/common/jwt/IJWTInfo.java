package com.farm.auth.common.jwt;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: IJWTInfo.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 17:08:29 <br />
 * 最后修改: 2018-09-03 17:08:29 <br />
 * 修改历史: <br />
 */
public interface IJWTInfo {
	/**
     * 获取用户名
     * @return
     */
	public String getUniqueName();

    /**
     * 获取用户ID
     * @return
     */
	public String getId();

    /**
     * 获取名称
     * @return
     */
	public String getName();
}