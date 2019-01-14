package com.seasonsfood.mall.business.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class WithdrawCashModel implements Serializable {

    /**
     * 提现方式，银行卡
     */
    public static final Short WITHDRAW_TYPE_BANK = 1;
    /**
     * 提现方式，支付宝
     */
    public static final Short WITHDRAW_TYPE_ALIPAY = 2;
    /**
     * 提现方式，微信
     */
    public static final Short WITHDRAW_TYPE_WECHAT = 3;
    /**
     * 提现金额
     */
    private BigDecimal money;

    /**
     * 备注
     */
    private String remark;

    /**
     * 提现方式  1 银行卡  2 支付宝  3 微信
     */
    private Short type;

    /**
     * 收款目标ID， 银行卡信息id ，支付宝信息id，微信信息id
     */
    private Long receiptId;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }
}
