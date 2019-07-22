package com.farm.admin.vo;

import com.farm.common.vo.TreeNode;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: GroupTree.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 15:29:34 <br />
 * 最后修改: 2018-09-05 15:29:34 <br />
 * 修改历史: <br />
 */
public class GroupTree extends TreeNode {
	
	private String label;
	
	private String name;
	
	/**
	 * 获取 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * 获取 
	 * @return the name
	 */
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
}