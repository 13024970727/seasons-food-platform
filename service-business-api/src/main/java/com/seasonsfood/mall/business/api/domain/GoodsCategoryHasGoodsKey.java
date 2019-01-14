package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author ron
 */
public class GoodsCategoryHasGoodsKey  implements Serializable {
    private static final long serialVersionUID = 2796138762552578173L;
    /**
    * 类别ID
    */
    @Id
    private Long goodsCategoryId;

    /**
    * 商品ID
    */
    @Id
    private Long goodsId;

    public Long getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Long goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}