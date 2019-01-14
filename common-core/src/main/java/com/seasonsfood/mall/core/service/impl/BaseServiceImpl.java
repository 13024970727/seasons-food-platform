package com.seasonsfood.mall.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.util.model.ListResponse;
import com.seasonsfood.mall.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ron
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    public Mapper<T> mapper;

    /**
     * 保存数据
     *
     * @param entity
     *
     * @return
     */
    @Override
    public int save(T entity) {
        return mapper.insert(entity);
    }


    /**
     * 保存数据，只保存有值的字段
     *
     * @param entity
     *
     * @return
     */
    @Override
    public int saveSelective(T entity) {
        return mapper.insertSelective(entity);
    }


    /**
     * 根新数据
     *
     * @param entity
     *
     * @return
     */
    @Override
    public int update(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    /**
     * 更新数据，只更新有值的字段
     *
     * @param entity
     *
     * @return
     */
    @Override
    public int updateSelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 删除
     *
     * @param entity
     *
     * @return
     */
    @Override
    public int delete(T entity) {
        return mapper.delete(entity);
    }

    /**
     * 根据ＩＤ获取数据
     *
     * @param entity
     *
     * @return
     */
    @Override
    public T selectByPrimary(T entity) {
        return mapper.selectByPrimaryKey(entity);
    }


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
    @Override
    public List<T> selectPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            return mapper.selectAll();
        } else {
            PageHelper.startPage(pageNum, pageSize);
            List<T> tList = mapper.selectAll();
            PageInfo pageInfo = new PageInfo(tList);
            if (pageInfo.getLastPage() + 1 <= pageNum) {
                return new ArrayList<>();
            }
            return tList;
        }
    }


    @Override
    public List<T> selectByEntityWithSimpleResult(T entity, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            return mapper.select(entity);
        } else {
            PageHelper.startPage(pageNum, pageSize);
            List<T> tList = mapper.select(entity);
            PageInfo pageInfo = new PageInfo(tList);
            //超出页数返回空
            if (pageInfo.getLastPage() + 1 <= pageNum) {
                return new ArrayList<>();
            }
            return tList;
        }
    }

    /**
     * 返回一个符合条件的实体，多个会抛出异常
     *
     * @param entity
     *
     * @return
     */
    @Override
    public T selectOne(T entity) {

        return mapper.selectOne(entity);
    }

    @Override
    public List<T> findAll() {

        return mapper.selectAll();
    }

    @Override
    public int addAllInList(List<T> entityList) {
        return 0;
    }

    @Override
    public List<T> select(T t) {
        return mapper.select(t);
    }

    /**
     * List封装成ListResponse
     *
     * @param list
     *
     * @return
     */
    protected ListResponse<T> listToResponse(List<T> list) {

        ListResponse<T> response = new ListResponse<>();

        if (null != list && 0 < list.size()) {

            PageInfo<T> pageInfo = new PageInfo<>(list);
            response.setCurrentPage(pageInfo.getPageNum());
            response.setTotal(pageInfo.getTotal());
            response.setRows(list);
            response.setTotalPage(pageInfo.getNavigateLastPage());
        } else {

            response.setTotal(0);
            response.setRows(null);
        }

        return response;
    }

    @Override
    public ListResponse<T> selectPageInListResponse(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            List<T> rows = mapper.selectAll();
            return new ListResponse<T>((long)rows.size(), 0, 0, rows);
        } else {
            PageHelper.startPage(pageNum, pageSize);
            List<T> tList = mapper.selectAll();
            PageInfo pageInfo = new PageInfo(tList);
            if (pageInfo.getLastPage() + 1 <= pageNum) {
                return new ListResponse<T>(0, 0, 0, new ArrayList<>());
            }
            return new ListResponse<T>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), tList);
        }
    }

    @Override
    public ListResponse<T> selectByEntityInListResponse(T entity, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            List<T> rows = mapper.selectAll();
            return new ListResponse<T>((long)rows.size(), 0, 0, rows);
        } else {
            PageHelper.startPage(pageNum, pageSize);
            List<T> tList = mapper.select(entity);
            PageInfo pageInfo = new PageInfo(tList);
            if (pageInfo.getLastPage() + 1 <= pageNum) {
                return new ListResponse<T>(0, 0, 0, new ArrayList<>());
            }
            return new ListResponse<T>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), tList);
        }
    }

    /**
     * 根据example的条件查找
     *
     * @param example
     * @param pageNum
     * @param pageSize
     *
     * @return
     */
    public List<T> selectPageByExample(Object example, Integer pageNum, Integer pageSize) {
        //当页数或页大小为空不进行分页
        if (pageNum == null || pageSize == null) {
            return mapper.selectByExample(example);
        } else {
            PageHelper.startPage(pageNum, pageSize);
            List<T> tList = mapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(tList);
            if (pageInfo.getLastPage() + 1 <= pageNum) {
                return new ArrayList<>();
            }
            return tList;
        }
    }


    /**
     * 根据example查询
     * @param example
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ListResponse<T> selectPageByExampleInListResponse(Example example, Integer pageNum, Integer pageSize) {
        //当页数或页大小为空不进行分页
        if (pageNum == null || pageSize == null) {
            List<T> rows = mapper.selectByExample(example);
            return new ListResponse<T>((long)rows.size(), 0, 0, rows);
        } else {
            PageHelper.startPage(pageNum, pageSize);
            List<T> tList = mapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(tList);
            if (pageInfo.getLastPage() + 1 <= pageNum) {
                return new ListResponse<T>(0, 0, 0, new ArrayList<>());
            }

            return new ListResponse<T>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), tList);
        }
    }

}
