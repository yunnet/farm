package com.farm.cache.utils;

import java.util.ArrayList;
import java.util.List;

import com.farm.cache.vo.CacheTree;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: TreeUtils.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:48:40 <br />
 * 最后修改: 2018-09-05 14:48:40 <br />
 * 修改历史: <br />
 */
public class TreeUtils {
	
	public static List<CacheTree> buildTree(List<CacheTree> trees) {
        List<CacheTree> list = new ArrayList<>();
        for (CacheTree tree : trees) {
            if (tree.getParentId().equals("-1")) {
                list.add(tree);
            }
            
            for (CacheTree t : trees) {
                if (t.getParentId().equals(tree.getId())) {
                    if (tree.getNodes() == null) {
                        List<CacheTree> myChildrens = new ArrayList<>();
                        myChildrens.add(t);
                        tree.setNodes(myChildrens);
                    } else {
                        tree.getNodes().add(t);
                    }
                }
            }
        }
        return list;
    }
}