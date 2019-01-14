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
@Table(name = "platform_sale_record")
public class PlatformSaleRecord implements Serializable {

    private static final long serialVersionUID = 6450176458908914928L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 精确到天，每天记录一条
    */
    private Date recordTime;

    /**
    * 销售金额
    */
    private BigDecimal saleMoney;

    /**
    * 销售订单数
    */
    private Integer saleOrderNumber;

    /**
    * 购买用户ID
    */
    private Integer buyUserNumber;

    /**
    * 首次购买用户ID
    */
    private Integer firstBuyUserNumber;

    /**
    * 总外送费用（统一）
    */
    private BigDecimal totalDeliveryFee;

    /**
    * 总外送费用（额外）
    */
    private BigDecimal totalDeliveryExtraFee;

    /**
    * 客单价（销售金额/订单数）
    */
    private String avgOrderValue;

    /**
    * 总抽点金额
    */
    private BigDecimal totalDraw;

    /**
    * 商户数量
    */
    private Integer shopUserNumber;

    /**
    * 平均抽点金额
    */
    private String avgDraw;

    /**
    * 创建时间
    */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public BigDecimal getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(BigDecimal saleMoney) {
        this.saleMoney = saleMoney;
    }

    public Integer getSaleOrderNumber() {
        return saleOrderNumber;
    }

    public void setSaleOrderNumber(Integer saleOrderNumber) {
        this.saleOrderNumber = saleOrderNumber;
    }

    public Integer getBuyUserNumber() {
        return buyUserNumber;
    }

    public void setBuyUserNumber(Integer buyUserNumber) {
        this.buyUserNumber = buyUserNumber;
    }

    public Integer getFirstBuyUserNumber() {
        return firstBuyUserNumber;
    }

    public void setFirstBuyUserNumber(Integer firstBuyUserNumber) {
        this.firstBuyUserNumber = firstBuyUserNumber;
    }

    public BigDecimal getTotalDeliveryFee() {
        return totalDeliveryFee;
    }

    public void setTotalDeliveryFee(BigDecimal totalDeliveryFee) {
        this.totalDeliveryFee = totalDeliveryFee;
    }

    public BigDecimal getTotalDeliveryExtraFee() {
        return totalDeliveryExtraFee;
    }

    public void setTotalDeliveryExtraFee(BigDecimal totalDeliveryExtraFee) {
        this.totalDeliveryExtraFee = totalDeliveryExtraFee;
    }

    public String getAvgOrderValue() {
        return avgOrderValue;
    }

    public void setAvgOrderValue(String avgOrderValue) {
        this.avgOrderValue = avgOrderValue;
    }

    public BigDecimal getTotalDraw() {
        return totalDraw;
    }

    public void setTotalDraw(BigDecimal totalDraw) {
        this.totalDraw = totalDraw;
    }

    public Integer getShopUserNumber() {
        return shopUserNumber;
    }

    public void setShopUserNumber(Integer shopUserNumber) {
        this.shopUserNumber = shopUserNumber;
    }

    public String getAvgDraw() {
        return avgDraw;
    }

    public void setAvgDraw(String avgDraw) {
        this.avgDraw = avgDraw;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}