package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "shop_settle_record")
public class ShopSettleRecord extends ShopSettleRecordKey implements Serializable {

    private static final long serialVersionUID = -3231232658737305058L;
    /**
    * 货款总额
    */
    private BigDecimal goodsMoney;

    /**
    * 货架费
    */
    private BigDecimal shelfFee;

    /**
    * 罚款金额
    */
    private BigDecimal dutyMoney;

    /**
    * 手续费率
    */
    private BigDecimal handleFeeRate;

    /**
    * 商家余额
    */
    private BigDecimal shopAccount;

    /**
    * 创建时间
    */
    private Date createTime;

    public BigDecimal getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(BigDecimal goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public BigDecimal getShelfFee() {
        return shelfFee;
    }

    public void setShelfFee(BigDecimal shelfFee) {
        this.shelfFee = shelfFee;
    }

    public BigDecimal getDutyMoney() {
        return dutyMoney;
    }

    public void setDutyMoney(BigDecimal dutyMoney) {
        this.dutyMoney = dutyMoney;
    }

    public BigDecimal getHandleFeeRate() {
        return handleFeeRate;
    }

    public void setHandleFeeRate(BigDecimal handleFeeRate) {
        this.handleFeeRate = handleFeeRate;
    }

    public BigDecimal getShopAccount() {
        return shopAccount;
    }

    public void setShopAccount(BigDecimal shopAccount) {
        this.shopAccount = shopAccount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}