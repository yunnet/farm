package com.farm.common.service;

import java.util.List;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: BaseService.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 16:38:31 <br />
 * 最后修改: 2018-09-03 16:38:31 <br />
 * 修改历史: <br />
 * @param <T>
 */
public interface BaseService<T> {
	
	/**
     * 查询
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    T selectById(Object id);

    /**
     * 根据ID集合来查询
     *
     * @param ids
     * @return
     */
//    List<T> selectListByIds(List<Object> ids);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<T> selectList(T entity);


    /**
     * 获取所有对象
     *
     * @return
     */
    List<T> selectListAll();


    /**
     * 查询总记录数
     *
     * @return
     */
//    Long selectCountAll();

    /**
     * 查询总记录数
     *
     * @param entity
     * @return
     */
    Long selectCount(T entity);

    /**
     * 添加
     *
     * @param entity
     */
    void insert(T entity);


    /**
     * 插入 不插入null字段
     *
     * @param entity
     */
    void insertSelective(T entity);

    /**
     * 删除
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 根据Id删除
     *
     * @param id
     */
    void deleteById(Object id);


    /**
     * 根据id更新
     *
     * @param entity
     */
    void updateById(T entity);


    /**
     * 不update null
     *
     * @param entity
     */
    void updateSelectiveById(T entity);

    /**
     * 根据ID集合批量删除
     *
     * @param ids
     */
//    void deleteBatchByIds(List<Object> ids);


    /**
     * 批量更新
     *
     * @param entitys
     */
//    void updateBatch(List<T> entitys);

}
