package com.seasonsfood.mall.delivery.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeliveryWithdrawRecord implements Serializable {
    private Long id;

    private Long deliveryUserId;

    /**
    * 提现金额
    */
    private BigDecimal money;

    /**
    * 改变后得金额
    */
    private BigDecimal changeAfter;

    /**
    * 状态 1 同意 2 拒绝
    */
    private Byte status;

    /**
    * 是否转账
    */
    private String isTransfer;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 提现账户
    */
    private String account;

    /**
    * 提现渠道 1 银行 2 支付宝 3 微信
    */
    private Byte accountFrom;

    /**
    * 账户名字
    */
    private String accountName;

    /**
    * 真实姓名
    */
    private String realName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getChangeAfter() {
        return changeAfter;
    }

    public void setChangeAfter(BigDecimal changeAfter) {
        this.changeAfter = changeAfter;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(String isTransfer) {
        this.isTransfer = isTransfer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Byte getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Byte accountFrom) {
        this.accountFrom = accountFrom;
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
}