package com.seasonsfood.mall.core.service;


import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

/**
 * @author ron
 */
public interface BaseService<T> {

    /**
     * 保存数据
     *
     * @param entity
     *
     * @return
     */
    public int save(T entity);

    /**
     * 保存数据，只保存有值的字段
     *
     * @param entity
     *
     * @return
     */
    public int saveSelective(T entity);


    /**
     * 根新数据
     *
     * @param entity
     *
     * @return
     */
    public int update(T entity);

    /**
     * 更新数据，只更新有值的字段
     *
     * @param entity
     *
     * @return
     */
    public int updateSelective(T entity);

    /**
     * 删除
     *
     * @param entity
     *
     * @return
     */
    public int delete(T entity);

    /**
     * 根据ＩＤ获取数据
     *
     * @param entity
     *
     * @return
     */
    public T selectByPrimary(T entity);


    /**
     * 分页查找
     *
     * @param pageNum
     *         　页数
     * @param pageSize
     *         　页大小
     *
     * @return
     */
    public List<T> selectPage(Integer pageNum, Integer pageSize);

    /**
     * 根据实体条件分页查询
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<T> selectByEntityWithSimpleResult(T entity, Integer pageNum, Integer pageSize);

    /**
     * 返回一个符合条件的实体，多个会抛出异常
     *
     * @param entity
     *
     * @return
     */
    public T selectOne(T entity);


    /**
     * 不分页查找所有
     *
     * @return
     */
    public List<T> findAll();

    /**
     * 批量插入
     */
    public int addAllInList(List<T> entityList);


    /**
     * 不分页条件查询
     * @param t 条件查询
     * @return 返回满足条件的所有结果
     */
    List<T> select(T t);



    /**
     * 根据实体找数据
     * @param entity
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ListResponse<T> selectByEntityInListResponse(T entity, Integer pageNum, Integer pageSize);


    /**
     * 分页查找数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ListResponse<T> selectPageInListResponse(Integer pageNum, Integer pageSize);


//    /**
//     * 根据example的条件查找
//     *
//     * @param example
//     * @param pageNum
//     * @param pageSize
//     *
//     * @return
//     */
//    public List<T> selectPageByExample(Object example, Integer pageNum, Integer pageSize);
//
//
//    /**
//     * 根据example找数据
//     * @param example
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    public ListResponse<T> selectPageByExampleInListResponse(Example example, Integer pageNum, Integer pageSize);

}
