package com.seasonsfood.mall.fontuser.api.domain;

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
@Table(name = "money_change_record")
public class MoneyChangeRecord implements Serializable {
    private static final long serialVersionUID = -4286802551260676024L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 金额
    */
    private BigDecimal money;

    /**
    * 用户当前余额
    */
    private BigDecimal userAccount;

    /**
    * 描述

    */
    private String remark;

    /**
    * 创建时间
    */
    private Date createTime;

    private Long fontUserId;

    /**
    * 变动类别  11 支付宝充值  12 微信充值 13 其他方式充值  14平台退款  15积分兑换
                       21 订单支付
    */
    private Short changeType;

    /**
    * 分布式事物所需字段
    */
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(BigDecimal userAccount) {
        this.userAccount = userAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getFontUserId() {
        return fontUserId;
    }

    public void setFontUserId(Long fontUserId) {
        this.fontUserId = fontUserId;
    }

    public Short getChangeType() {
        return changeType;
    }

    public void setChangeType(Short changeType) {
        this.changeType = changeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}