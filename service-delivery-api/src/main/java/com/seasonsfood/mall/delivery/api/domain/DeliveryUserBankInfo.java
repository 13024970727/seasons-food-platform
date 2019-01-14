package com.seasonsfood.mall.delivery.api.domain;

import java.io.Serializable;
import java.util.Date;

public class DeliveryUserBankInfo implements Serializable {
    private Integer id;

    /**
    * 银行
    */
    private String bank;

    /**
    * 卡号
    */
    private String cardNumber;

    /**
    * 真实姓名
    */
    private String realName;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 外送员id
    */
    private Long deliveryUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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