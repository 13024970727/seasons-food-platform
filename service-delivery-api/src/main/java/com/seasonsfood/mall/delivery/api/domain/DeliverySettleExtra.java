package com.seasonsfood.mall.delivery.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeliverySettleExtra implements Serializable {
    private Long id;

    /**
    * 子项名
    */
    private String itemName;

    /**
    * 子项值
    */
    private BigDecimal itemValue;

    /**
    *  1 加钱 2 扣钱
    */
    private Short itemType;

    /**
    * 描述
    */
    private String description;

    /**
    * 记录时间，精确到月
    */
    private Date recordTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 外送员id
    */
    private Long deliveryUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemValue() {
        return itemValue;
    }

    public void setItemValue(BigDecimal itemValue) {
        this.itemValue = itemValue;
    }

    public Short getItemType() {
        return itemType;
    }

    public void setItemType(Short itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }
}