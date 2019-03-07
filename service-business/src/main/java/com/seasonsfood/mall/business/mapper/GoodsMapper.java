package com.seasonsfood.mall.business.mapper;

import com.seasonsfood.mall.business.api.domain.Goods;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author ron
 */
public interface GoodsMapper extends Mapper<Goods> {
    /**
    * 更新全部商品价格.
    *
      * @param
    * @return void
    */
    void updateAllGoodsPrice();


    Goods selectGoodsName(Long goodsId);
}