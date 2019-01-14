package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author ron
 */
public class ShopPriceRecordKey implements Serializable {
    /**
    * 商品id
    */
    @Id
    private Long goodsId;

    /**
    * 商铺id
    */
    @Id
    private Long shopBaseInfoId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }
}