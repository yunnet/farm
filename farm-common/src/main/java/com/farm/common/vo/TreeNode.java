package com.farm.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: TreeNode.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 16:46:26 <br />
 * 最后修改: 2018-09-03 16:46:26 <br />
 * 修改历史: <br />
 */
public class TreeNode {
	protected int id;
    protected int parentId;
    
    List<TreeNode> children = new ArrayList<>();

	/**
	 * 获取 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取 
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * 设置 
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取 
	 * @return the children
	 */
	public List<TreeNode> getChildren() {
		return children;
	}

	/**
	 * 设置 
	 * @param children the children to set
	 */
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	public void add(TreeNode node){
        children.add(node);
    }
}