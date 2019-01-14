package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author ron
 */
public class GoodsOrderHasGoodsKey implements Serializable {
    private static final long serialVersionUID = 9187463819507085492L;
    /**
    * 商品ID
    */
    @Id
    private Long goodsId;

    /**
    * 订单ID
    */
    @Id
    private Long userGoodsOrderId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getUserGoodsOrderId() {
        return userGoodsOrderId;
    }

    public void setUserGoodsOrderId(Long userGoodsOrderId) {
        this.userGoodsOrderId = userGoodsOrderId;
    }
}