package com.farm.auth.server.biz;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.auth.server.entity.Client;
import com.farm.auth.server.entity.ClientService;
import com.farm.auth.server.mapper.ClientMapper;
import com.farm.auth.server.mapper.ClientServiceMapper;
import com.farm.common.biz.BaseBiz;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: ClientBiz.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 14:08:51 <br />
 * 最后修改: 2018-09-04 14:08:51 <br />
 * 修改历史: <br />
 */
@Service
public class ClientBiz extends BaseBiz<ClientMapper, Client> {
	@Autowired
    private ClientServiceMapper clientServiceMapper;
	
    @Autowired
    private ClientServiceBiz clientServiceBiz;
	
    public List<Client> getClientServices(int id) {
        return mapper.selectAuthorityServiceInfo(id);
    }

    public void modifyClientServices(int id, String clients) {
        clientServiceMapper.deleteByServiceId(id);
        
        if (!StringUtils.isEmpty(clients)) {
            String[] mem = clients.split(",");
            for (String s : mem) {
                ClientService clientService = new ClientService();
                clientService.setServiceId(s);
                clientService.setClientId("" + id);
                
                clientServiceBiz.insertSelective(clientService);
            }
        }
    }
}