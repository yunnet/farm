package com.farm.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.farm.common.service.BaseService;

import tk.mybatis.mapper.common.Mapper;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: BaseServiceImpl.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 16:39:59 <br />
 * 最后修改: 2018-09-03 16:39:59 <br />
 * 修改历史: <br />
 */
public class BaseServiceImpl<M extends Mapper<T>, T> implements BaseService<T> {
	@Autowired
    protected M mapper;

	@Override
	public T selectOne(T t) {
		return mapper.selectOne(t);
	}

	@Override
	public T selectById(Object id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<T> selectList(T t) {
		return mapper.select(t);
	}

	@Override
	public List<T> selectListAll() {
		return mapper.selectAll();
	}

	@Override
	public Long selectCount(T t) {
		 return Long.valueOf(mapper.selectCount(t));
	}

	@Override
	public void insert(T t) {
		mapper.insert(t);
	}

	@Override
	public void insertSelective(T t) {
		mapper.insertSelective(t);
	}

	@Override
	public void delete(T t) {
		mapper.delete(t);
	}

	@Override
	public void deleteById(Object id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateById(T t) {
		mapper.updateByPrimaryKey(t);
	}

	@Override
	public void updateSelectiveById(T t) {
		mapper.updateByPrimaryKeySelective(t);
	}
}