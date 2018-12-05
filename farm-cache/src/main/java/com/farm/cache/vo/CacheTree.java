package com.farm.cache.vo;

import java.util.ArrayList;
import java.util.List;

import com.farm.cache.entity.CacheBean;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: CacheTree.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:36:27 <br />
 * 最后修改: 2018-09-05 14:36:27 <br />
 * 修改历史: <br />
 */
public class CacheTree extends CacheBean{
	private String id;
	
    private String parentId;
    
    private String text = null;
    
    private List<CacheTree> nodes = new ArrayList<>();
    
    /**
	 * 构造函数
	 */
	public CacheTree() {
		
	}
    
    /**
     * 构造函数
     * @param cache
     */
	public CacheTree(CacheBean cache) {
		this.setKey(cache.getKey());
		this.setDesc(cache.getDesc());
		this.setExpireTime(cache.getExpireTime());
	}

	/**
	 * 获取 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 设置 
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	public List<CacheTree> getNodes() {
		return nodes;
	}

	/**
	 * 设置 
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<CacheTree> nodes) {
		this.nodes = nodes;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        CacheTree other = (CacheTree) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
            return false;
        return true;
    }

}
