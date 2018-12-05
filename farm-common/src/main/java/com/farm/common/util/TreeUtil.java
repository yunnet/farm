package com.farm.common.util;

import java.util.ArrayList;
import java.util.List;

import com.farm.common.vo.TreeNode;

/**
 * 版权所有: 2018 ® kexin Company <br />
 * 单元名称: TreeUtil.java <br />
 * 说 明: <br />
 * 作 者: yunnet <br />
 * 创建时间: 2018-09-05 15:31:02 <br />
 * 最后修改: 2018-09-05 15:31:02 <br />
 * 修改历史: <br />
 */
public class TreeUtil {
	/**
	 * 两层循环实现建树
	 * 
	 * @param treeNodes 传入的树节点列表
	 * @return
	 */
	public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {
		List<T> trees = new ArrayList<>();

		for (T treeNode : treeNodes) {

			if (root.equals(treeNode.getParentId())) {
				trees.add(treeNode);
			}

			for (T it : treeNodes) {
				if (it.getParentId() == treeNode.getId()) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<>());
					}
					treeNode.add(it);
				}
			}
		}
		return trees;
	}

	/**
	 * 使用递归方法建树
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
		List<T> trees = new ArrayList<>();
		for (T treeNode : treeNodes) {
			if (root.equals(treeNode.getParentId())) {
				trees.add(findChildren(treeNode, treeNodes));
			}
		}
		return trees;
	}

	/**
	 * 递归查找子节点
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
		for (T it : treeNodes) {
			if (treeNode.getId() == it.getParentId()) {
				if (treeNode.getChildren() == null) {
					treeNode.setChildren(new ArrayList<>());
				}
				treeNode.add(findChildren(it, treeNodes));
			}
		}
		return treeNode;
	}
}