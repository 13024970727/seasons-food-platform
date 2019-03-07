package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.business.api.domain.GoodsConsignmentWarehouse;
import com.seasonsfood.mall.business.api.domain.GoodsMeteringUnit;
import com.seasonsfood.mall.business.api.service.GoodsConsignmentWarehouseService;
import com.seasonsfood.mall.business.mapper.GoodsConsignmentWarehouseMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;


@Component
@Service(interfaceClass = GoodsConsignmentWarehouseService.class)
public class GoodsConsignmentWarehouseServiceImpl extends BaseServiceImpl<GoodsConsignmentWarehouse> implements GoodsConsignmentWarehouseService {

    @Resource
    GoodsConsignmentWarehouseMapper goodsConsignmentWarehouseMapper;

    @Override
    public ListResponse<GoodsConsignmentWarehouse> findList(Integer pageNum, Integer pageSize) {
        Example example = new Example(GoodsMeteringUnit.class);
        Example.Criteria criteria = example.createCriteria();
        PageHelper.startPage(pageNum, pageSize);
        //可根据要查找的字段进行查找
        //example.selectProperties("");
        PageInfo<GoodsConsignmentWarehouse> pageInfo = new PageInfo<>(goodsConsignmentWarehouseMapper.selectByExample(example));
        return new ListResponse(pageInfo);
    }
}
