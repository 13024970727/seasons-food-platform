package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "goods_order_has_goods")
public class GoodsOrderHasGoods extends GoodsOrderHasGoodsKey implements Serializable {
    private static final long serialVersionUID = 3214448175016922536L;
    /**
    * 供货商铺ID
    */
    private Long shopBaseInfoId;

    /**
    * 买时每份的价格
    */
    private BigDecimal perPrice;

    /**
    * 买时每份的单位数量
    */
    private BigDecimal unitNumber;

    /**
    * 买时的基础单位
    */
    private String unitSpecification;

    /**
    * 异常信息ID
    */
    private Long goodsDeviantId;

    /**
    * 状态  1 正常 2 缺货 3 破损 4 重量超标 5 重量不足
    */
    private Short status;

    /**
    * 备注
    */
    private String remark;

    /**
    * 创建时间
    */
    private Date createTime;

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }

    public BigDecimal getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(BigDecimal perPrice) {
        this.perPrice = perPrice;
    }

    public BigDecimal getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(BigDecimal unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitSpecification() {
        return unitSpecification;
    }

    public void setUnitSpecification(String unitSpecification) {
        this.unitSpecification = unitSpecification;
    }

    public Long getGoodsDeviantId() {
        return goodsDeviantId;
    }

    public void setGoodsDeviantId(Long goodsDeviantId) {
        this.goodsDeviantId = goodsDeviantId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}