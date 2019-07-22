package com.farm.common.biz;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.farm.common.msg.TableResultResponse;
import com.farm.common.util.EntityUtils;
import com.farm.common.util.Query;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: BaseBiz.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 14:26:51 <br />
 * 最后修改: 2018-09-03 14:26:51 <br />
 * 修改历史: <br />
 */
public abstract class BaseBiz<M extends Mapper<T>, T> {
	@Autowired
	protected M mapper;
	
	public void setMapper(M mapper) {
		this.mapper = mapper;
	}
	
	public T selectOne(T t) {
		return mapper.selectOne(t);
	}
	
	public T selectById(Object id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	public List<T> selectList(T t) {
        return mapper.select(t);
    }

    public List<T> selectListAll() {
        return mapper.selectAll();
    }

    public Long selectCount(T t) {
        return new Long(mapper.selectCount(t));
    }
    
    public void insert(T entity) {
        EntityUtils.setCreateAndUpdateInfo(entity);
        mapper.insert(entity);
    }

    public void insertSelective(T entity) {
        EntityUtils.setCreateAndUpdateInfo(entity);
        mapper.insertSelective(entity);
    }

    public void delete(T entity) {
        mapper.delete(entity);
    }

    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void updateById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKey(entity);
    }

    public void updateSelectiveById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }
    
    @SuppressWarnings("unchecked")
    public TableResultResponse<T> selectByQuery(Query query) {
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        if(query.entrySet().size() > 0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        return new TableResultResponse<T>(result.getTotal(), list);
    }
}
