package com.seasonsfood.mall.delivery.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeliverySettleRecord implements Serializable {
    private Integer id;

    /**
    * 配送天数
    */
    private Integer deliveryDay;

    /**
    * 配送数
    */
    private Integer deliveryNumber;

    /**
    * 基础工资
    */
    private BigDecimal basePay;

    /**
    * 油费
    */
    private BigDecimal oilSubsidy;

    /**
    * 外送补贴
    */
    private BigDecimal deliverySubsidy;

    /**
    * 总工资
    */
    private BigDecimal totalPay;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    * 创建时间
    */
    private Date createTime;

    private Long deliveryUserId;

    /**
    * 记录时间，精确到月
    */
    private Date recordTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(Integer deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public Integer getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Integer deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public BigDecimal getBasePay() {
        return basePay;
    }

    public void setBasePay(BigDecimal basePay) {
        this.basePay = basePay;
    }

    public BigDecimal getOilSubsidy() {
        return oilSubsidy;
    }

    public void setOilSubsidy(BigDecimal oilSubsidy) {
        this.oilSubsidy = oilSubsidy;
    }

    public BigDecimal getDeliverySubsidy() {
        return deliverySubsidy;
    }

    public void setDeliverySubsidy(BigDecimal deliverySubsidy) {
        this.deliverySubsidy = deliverySubsidy;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}