package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "goods_category_has_goods")
public class GoodsCategoryHasGoods extends GoodsCategoryHasGoodsKey implements Serializable {
    private static final long serialVersionUID = 7731043066163153331L;
    /**
    * 商户ID，在某个类别下的某个商品归属于某个商户
    */
    private Long shopBaseInfoId;

    public Long getShopBaseInfoId() { return shopBaseInfoId;
    }
    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }
}