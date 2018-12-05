package com.farm.admin.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farm.admin.biz.GroupTypeBiz;
import com.farm.admin.entity.GroupType;
import com.farm.common.rest.BaseController;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: GroupTypeController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 15:48:30 <br />
 * 最后修改: 2018-09-05 15:48:30 <br />
 * 修改历史: <br />
 */
@Controller
@RequestMapping("groupType")
public class GroupTypeController extends BaseController<GroupTypeBiz, GroupType> {

}
