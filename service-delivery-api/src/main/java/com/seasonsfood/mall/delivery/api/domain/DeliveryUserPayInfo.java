package com.seasonsfood.mall.delivery.api.domain;

import java.io.Serializable;
import java.util.Date;

public class DeliveryUserPayInfo implements Serializable {
    private Long id;

    /**
    * 第三方支付  2 支付宝 3 微信
    */
    private Byte payType;

    /**
    * 账户
    */
    private String account;

    /**
    * 账户名
    */
    private String accountName;

    /**
    * 真实名
    */
    private String realName;

    /**
    * 创建时间
    */
    private Date createTime;

    private Long deliveryUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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