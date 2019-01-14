package com.seasonsfood.mall.delivery.api.domain;

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
@Table(name = "delivery_record")
public class DeliveryRecord implements Serializable {
    private static final long serialVersionUID = -5631027437732945031L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 配送开始时间
    */
    private Date startTime;

    /**
    * 配送结束时间
    */
    private Date endTime;

    /**
    * 配送数量
    */
    private Integer deliveryNumber;

    /**
    * 配送效率
    */
    private BigDecimal deliveryEfficiency;

    /**
    * 记录到年月日 yyyy-MM-dd 00:00:00
    */
    private Date recordDate;

    private Long deliveryUserId;

    /**
    * 配送总时间,单位分钟
    */
    private BigDecimal deliveryTime;

    /**
    * 配送的总价值
    */
    private BigDecimal deliveryValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Integer deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public BigDecimal getDeliveryEfficiency() {
        return deliveryEfficiency;
    }

    public void setDeliveryEfficiency(BigDecimal deliveryEfficiency) {
        this.deliveryEfficiency = deliveryEfficiency;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public BigDecimal getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(BigDecimal deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public BigDecimal getDeliveryValue() {
        return deliveryValue;
    }

    public void setDeliveryValue(BigDecimal deliveryValue) {
        this.deliveryValue = deliveryValue;
    }
}