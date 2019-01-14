package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.Goods;
import com.seasonsfood.mall.business.api.domain.GoodsCategory;
import com.seasonsfood.mall.business.api.domain.GoodsCategoryHasGoods;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * @Author zhaozhirong
 * @Date 2018/12/7 17:54
 * 商品接口
 */
public interface GoodsService extends BaseService<Goods> {
    /**
     * 添加新的商品.
     *
     * @param goods                 商品信息
     * @param goodsCategoryHasGoods 商品类别和店铺信息
     * @return com.seasonsfood.mall.util.constant.ResponseCode
     */
    ResponseCode addNewGoods(Goods goods, GoodsCategoryHasGoods goodsCategoryHasGoods);

    /**
     * 商家更新商品信息.
     *
     * @param goods 只更新价格和库存以及是否上架
     * @return com.seasonsfood.mall.util.constant.ResponseCode
     */
    ResponseCode updateGoodsByShop(Goods goods);

    /**
     * 系统定时更新全部商品价格.
     *
     * @param
     * @return void
     */
    void updateAllGoodsPrice();

    ResponseCode updateGoodsByAdmin(Goods goods);
}