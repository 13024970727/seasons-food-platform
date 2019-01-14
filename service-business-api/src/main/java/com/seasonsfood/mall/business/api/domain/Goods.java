package com.seasonsfood.mall.business.api.domain;

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
@Table(name = "goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = -8463368328418915521L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * sku编码
     */
    private String sku;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 当前单价（一份的价格）
     */
    private BigDecimal currentPrice;

    /**
     * 改变单价，今天改，明天生效（一份的价格）
     */
    private BigDecimal changePrice;

    /**
     * 一份的单位数量
     */
    private BigDecimal unitNumber;

    /**
     * 单位规格（g,kg,盒，箱,默认g）
     */
    private String unitSpecification;

    /**
     * 是否客户支持自定义重量
     */
    private Byte isCustom;

    /**
     * 库存数量
     */
    private Integer stockQuantity;

    /**
     * 预警数量
     */
    private Integer warnQuantity;

    /**
     * 卖出数量
     */
    private Integer saleQuantity;

    /**
     * 每日数量，每天将每日数量和库存同步
     */
    private Integer dailyQuantity;

    /**
     * 额外的快递费用
     */
    private BigDecimal extralDeliveryFee;

    /**
     * 返点
     */
    private String rebate;

    /**
     * 1 平台配送 2 商家配送
     */
    private Short deliveryType;
    /**
     * 商品是否上架，0未上架，1上架.
     */
    private Boolean onSale;
    /**
     * 商品创建日期.
     */
    private Date createTime;
    /**
     * 实际重量计算参数
     */
    private BigDecimal weightParams;

    /**
     * 商品排序
     */
    private Short sortNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(BigDecimal changePrice) {
        this.changePrice = changePrice;
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

    public Byte getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Byte isCustom) {
        this.isCustom = isCustom;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getWarnQuantity() {
        return warnQuantity;
    }

    public void setWarnQuantity(Integer warnQuantity) {
        this.warnQuantity = warnQuantity;
    }

    public Integer getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public Integer getDailyQuantity() {
        return dailyQuantity;
    }

    public void setDailyQuantity(Integer dailyQuantity) {
        this.dailyQuantity = dailyQuantity;
    }

    public BigDecimal getExtralDeliveryFee() {
        return extralDeliveryFee;
    }

    public void setExtralDeliveryFee(BigDecimal extralDeliveryFee) {
        this.extralDeliveryFee = extralDeliveryFee;
    }

    public String getRebate() {
        return rebate;
    }

    public void setRebate(String rebate) {
        this.rebate = rebate;
    }

    public Short getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Short deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BigDecimal getWeightParams() {
        return weightParams;
    }

    public void setWeightParams(BigDecimal weightParams) {
        this.weightParams = weightParams;
    }

    public Short getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Short sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Date getCreateTime() {
        Date date=(Date)createTime.clone();
        return date;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = (Date) createTime.clone();
    }
}