package com.seasonsfood.mall.business.api.domain;

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
@Table(name = "shop_withdraw_record")
public class ShopWithdrawRecord implements Serializable {

    private static final long serialVersionUID = -3287910460947187703L;
    /**
     * 提现状态，审核中
     */
    public static final Short  WITHDRAW_STATUS_AUDITING=1;
    /**
     * 提现状态，审核通过
     */
    public static final Short  WITHDRAW_STATUS_PASS=2;
    /**
     * 提现状态，审核不通过
     */
    public static final Short  WITHDRAW_STATUS_NO_PASS=3;
    /**
     * 提现方式，银行卡
     */
    public static final Short  WITHDRAW_TYPE_BANK=1;
    /**
     * 提现方式，支付宝
     */
    public static final Short  WITHDRAW_TYPE_ALIPAY=2;
    /**
     * 提现方式，微信
     */
    public static final Short  WITHDRAW_TYPE_WECHAT=3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 提现用户ID
    */
    private Long shopUserId;

    /**
    * 所属商铺ID
    */
    private Long shopBaseInfoId;

    /**
    * 提现金额
    */
    private BigDecimal withdrawMoney;
    /**
    * 提现后当前店铺金额
    */
    private BigDecimal currentMoney;



    /**
    * 备注
    */
    private String remark;

    /**
    * 状态  1 提现中 2 审核通过 3 审核不通过
    */
    private Short status;

    /**
    * 提现方式  1 银行卡  2 支付宝  3 微信
    */
    private Short withdrawType;

    /**
    * 账户
    */
    private String cardNumber;

    /**
    * 账户来源  支付宝  兴业银行等
    */
    private String accountFrom;

    /**
    * 真实姓名
    */
    private String realName;

    /**
    * 是否已经转账
    */
    private Boolean isTransfer;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
     * 收款二维码信息
     */
    private String qrcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }

    public BigDecimal getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(BigDecimal withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(Short withdrawType) {
        this.withdrawType = withdrawType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Boolean getTransfer() {
        return isTransfer;
    }

    public void setTransfer(Boolean transfer) {
        isTransfer = transfer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}