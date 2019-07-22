package com.farm.auth.server.service;

import java.util.List;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: AuthClientService.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 13:03:08 <br />
 * 最后修改: 2018-09-04 13:03:08 <br />
 * 修改历史: <br />
 */
public interface AuthClientService {
	
	public String apply(String clientId, String secret) throws Exception;

    /**
     * 获取授权的客户端列表
     * @param serviceId
     * @param secret
     * @return
     */
    public List<String> getAllowedClient(String serviceId, String secret);

    /**
     * 获取服务授权的客户端列表
     * @param serviceId
     * @return
     */
    public List<String> getAllowedClient(String serviceId);

    public void registryClient();

    public void validate(String clientId, String secret) throws Exception;

}
