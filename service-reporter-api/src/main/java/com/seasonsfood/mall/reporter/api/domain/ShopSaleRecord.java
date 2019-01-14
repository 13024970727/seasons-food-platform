package com.seasonsfood.mall.reporter.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "shop_sale_record")
public class ShopSaleRecord implements Serializable {

    private static final long serialVersionUID = 7360313884935762121L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 商铺id
    */
    private Long shopBaseInfoId;

    /**
    * 当前商品数量
    */
    private Integer goodsNumber;

    /**
    * 每日的订单金额
    */
    private Integer orderNumber;

    /**
    * 记录时间
    */
    private Date recordTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 平台总金额
    */
    private BigDecimal platformTotalSale;

    /**
    * 占平台销售额的百分比
    */
    private BigDecimal saleRate;

    /**
    * 店铺月销售总额
    */
    private BigDecimal mothShopTotalSale;

    /**
    * 平台销售总额
    */
    private BigDecimal monthPlatformTotalSale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPlatformTotalSale() {
        return platformTotalSale;
    }

    public void setPlatformTotalSale(BigDecimal platformTotalSale) {
        this.platformTotalSale = platformTotalSale;
    }

    public BigDecimal getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(BigDecimal saleRate) {
        this.saleRate = saleRate;
    }

    public BigDecimal getMothShopTotalSale() {
        return mothShopTotalSale;
    }

    public void setMothShopTotalSale(BigDecimal mothShopTotalSale) {
        this.mothShopTotalSale = mothShopTotalSale;
    }

    public BigDecimal getMonthPlatformTotalSale() {
        return monthPlatformTotalSale;
    }

    public void setMonthPlatformTotalSale(BigDecimal monthPlatformTotalSale) {
        this.monthPlatformTotalSale = monthPlatformTotalSale;
    }
}