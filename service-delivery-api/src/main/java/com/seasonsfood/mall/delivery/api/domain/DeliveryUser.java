package com.seasonsfood.mall.delivery.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeliveryUser implements Serializable {
    private Long id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 电话号
    */
    private String phone;

    /**
    * 密码
    */
    private String password;

    /**
    * 身份证
    */
    private String idCardNumber;

    /**
    * 金额
    */
    private BigDecimal account;

    /**
    * 冻结金额（体现中的金额）
    */
    private BigDecimal lockAccount;

    /**
    * 开放平台ID
    */
    private String openId;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 盐
    */
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public BigDecimal getLockAccount() {
        return lockAccount;
    }

    public void setLockAccount(BigDecimal lockAccount) {
        this.lockAccount = lockAccount;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}