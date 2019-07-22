package com.farm.admin.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.admin.entity.ResourceAuthority;
import com.farm.admin.mapper.ResourceAuthorityMapper;
import com.farm.common.biz.BaseBiz;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ResourceAuthorityBiz.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 15:20:49 <br />
 * 最后修改: 2018-09-05 15:20:49 <br />
 * 修改历史: <br />
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper, ResourceAuthority> {

}
