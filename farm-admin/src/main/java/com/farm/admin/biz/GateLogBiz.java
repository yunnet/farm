package com.farm.admin.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.admin.entity.GateLog;
import com.farm.admin.mapper.GateLogMapper;
import com.farm.common.biz.BaseBiz;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: GateLogBiz.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:51:07 <br />
 * 最后修改: 2018-09-05 14:51:07 <br />
 * 修改历史: <br />
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GateLogBiz extends BaseBiz<GateLogMapper,GateLog> {
	@Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
