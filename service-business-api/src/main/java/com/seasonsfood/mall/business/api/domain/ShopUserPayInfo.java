package com.seasonsfood.mall.business.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "shop_user_pay_info")
public class ShopUserPayInfo implements Serializable {

    private static final long serialVersionUID = -965029612626442560L;
    /**
     * 支付类型 支付宝
     */
    public static final Short PAY_TYPE_ALIPAY = 2;
    /**
     * 支付类型 微信
     */
    public static final Short PAY_TYPE_WECHAT = 3;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 第三方支付  2 支付宝 3 微信
     */
    private Short payType;

    /**
     * 账户收款码
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

    /**
     * 商户id
     */
    private Long shopUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
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

    public Long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }
}