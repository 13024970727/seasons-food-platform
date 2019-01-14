package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "shop_price_record")
public class ShopPriceRecord extends ShopPriceRecordKey implements Serializable {

    private static final long serialVersionUID = 3889555764039851097L;

    /**
    * 商品价格
    */
    private BigDecimal goodsPrice;

    /**
    * 价格变动时间
    */
    private Date changeTime;

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
}