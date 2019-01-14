package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.GoodsCategory;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * @Author zhaozhirong
 * @Date 2018/12/7 11:17
 */
public interface GoodsCategoryService extends BaseService<GoodsCategory> {
    /**
     * 添加新的商品类别.
     *
     * @param goodsCategory
     * @return ResponseCode
     */
    ResponseCode addNewGoodsCategory(GoodsCategory goodsCategory);
    /**
     * 通过商品类别id查找商品类别信息.
     *
     * @param id
     * @return ResponseCode
     */
    GoodsCategory selectByPrimaryKey(Long id);
}