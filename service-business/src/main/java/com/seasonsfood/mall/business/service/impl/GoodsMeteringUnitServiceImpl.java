package com.seasonsfood.mall.business.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.business.api.domain.GoodsMeteringUnit;
import com.seasonsfood.mall.business.api.service.GoodsMeteringUnitService;
import com.seasonsfood.mall.business.mapper.GoodsMeteringUnitMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;


@Component("meteringUnitService")
@Service(interfaceClass = GoodsMeteringUnitService.class)
public class GoodsMeteringUnitServiceImpl extends BaseServiceImpl<GoodsMeteringUnit> implements GoodsMeteringUnitService {

    @Resource
    GoodsMeteringUnitMapper goodsMeteringUnitMapper;

    @Override
    public ListResponse<GoodsMeteringUnit> getMeteringUnitList(String unitName, Byte stateId, Integer pageNum, Integer pageSize) {
        Example example = new Example(GoodsMeteringUnit.class);
        Example.Criteria criteria = example.createCriteria();
        if (null != unitName) {
            String inputName = "%" + unitName + "%";
            criteria.andLike("unitName", inputName);
        }
        if (null == stateId) {
            stateId = 1;
            criteria.andEqualTo("stateId", stateId);
        } else {
            criteria.andEqualTo("stateId", stateId);
        }
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<GoodsMeteringUnit> pageInfo = new PageInfo<>(goodsMeteringUnitMapper.selectByExample(example));
        return new ListResponse(pageInfo);
    }
}
