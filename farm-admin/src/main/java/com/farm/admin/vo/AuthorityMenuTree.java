package com.farm.admin.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.farm.common.vo.TreeNode;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: AuthorityMenuTree.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 15:08:02 <br />
 * 最后修改: 2018-09-05 15:08:02 <br />
 * 修改历史: <br />
 */
public class AuthorityMenuTree extends TreeNode implements Serializable{
	private static final long serialVersionUID = 673887563645855799L;

	private String text;
	
	private List<AuthorityMenuTree> nodes = new ArrayList<>();
	
	private String icon;
	
	/**
	 *  构造函数
	 */
	public AuthorityMenuTree() {
		
	}
	
	/**
	 * 构造函数
	 * @param text
	 * @param nodes
	 */
	public AuthorityMenuTree(String text, List<AuthorityMenuTree> nodes) {
		this.text = text;
        this.nodes = nodes;
	}

	/**
	 * 获取 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * 设置 
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 获取 
	 * @return the nodes
	 */
	public List<AuthorityMenuTree> getNodes() {
		return nodes;
	}

	/**
	 * 设置 
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<AuthorityMenuTree> nodes) {
		this.nodes = nodes;
	}

	/**
	 * 获取 
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置 
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Override
    public void setChildren(List<TreeNode> children) {
        super.setChildren(children);
        nodes = new ArrayList<>();
    }

    @Override
    public void add(TreeNode node) {
        super.add(node);
        AuthorityMenuTree n = new AuthorityMenuTree();
        BeanUtils.copyProperties(node,n);
        nodes.add(n);
    }
}