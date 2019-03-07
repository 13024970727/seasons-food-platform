package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.GoodsCategory;
import com.seasonsfood.mall.business.api.service.GoodsCategoryService;
import com.seasonsfood.mall.business.mapper.GoodsCategoryMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.constant.ResponseCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author zhaozhirong
 * @Date 2018/12/7 11:20
 */
@Component
@Service(interfaceClass = GoodsCategoryService.class)
public class GoodsCategoryServiceImpl extends BaseServiceImpl<GoodsCategory> implements GoodsCategoryService {

    @Resource
    GoodsCategoryMapper goodsCategoryMapper;

    /**
     * 添加商品种类
     * @param goodsCategory
     * @return
     */
    @Override
    public ResponseCode addNewGoodsCategory(GoodsCategory goodsCategory)  {
        if (goodsCategory.getParentId() == null) {
            goodsCategory.setParentId(-1L);
            goodsCategory.setLevel(GoodsCategory.LEVEL_ONE);
        }
        goodsCategory.setCreateTime(new Date());
        mapper.insertSelective(goodsCategory);
        return ResponseCode.SUCCESS;
    }

    @Override
    public GoodsCategory selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}