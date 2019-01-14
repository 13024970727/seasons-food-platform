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
@Table(name = "goods_deviant")
public class GoodsDeviant implements Serializable {
    private static final long serialVersionUID = 2100264011757971030L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 异常名字
    */
    private String deviantStatuName;

    /**
    * 平台承担的费用
    */
    private BigDecimal platformDutyMoney;

    /**
    * 快递员承担的费用
    */
    private BigDecimal deliveryDutyMoney;

    /**
    * 用户承担的费用
    */
    private BigDecimal userDutyMoney;

    /**
    * 店铺承担的费用
    */
    private BigDecimal shopDutyMoney;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 备注
    */
    private String remark;

    /**
    * 用户看到的异常信息
    */
    private String userView;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviantStatuName() {
        return deviantStatuName;
    }

    public void setDeviantStatuName(String deviantStatuName) {
        this.deviantStatuName = deviantStatuName;
    }

    public BigDecimal getPlatformDutyMoney() {
        return platformDutyMoney;
    }

    public void setPlatformDutyMoney(BigDecimal platformDutyMoney) {
        this.platformDutyMoney = platformDutyMoney;
    }

    public BigDecimal getDeliveryDutyMoney() {
        return deliveryDutyMoney;
    }

    public void setDeliveryDutyMoney(BigDecimal deliveryDutyMoney) {
        this.deliveryDutyMoney = deliveryDutyMoney;
    }

    public BigDecimal getUserDutyMoney() {
        return userDutyMoney;
    }

    public void setUserDutyMoney(BigDecimal userDutyMoney) {
        this.userDutyMoney = userDutyMoney;
    }

    public BigDecimal getShopDutyMoney() {
        return shopDutyMoney;
    }

    public void setShopDutyMoney(BigDecimal shopDutyMoney) {
        this.shopDutyMoney = shopDutyMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserView() {
        return userView;
    }

    public void setUserView(String userView) {
        this.userView = userView;
    }
}