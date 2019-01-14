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
@Table(name = "user_coupon")
public class UserCoupon implements Serializable {

    private static final long serialVersionUID = -1165860769586683993L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 优惠卷名称
    */
    private String couponName;

    /**
    * 抵扣金额
    */
    private BigDecimal money;

    /**
    * 使用开始时间
    */
    private Date useStartTime;

    /**
    * 使用结束时间
    */
    private Date useEndTime;

    /**
    * 优惠卷类别  1 无门槛  2 抵扣通用运费 3 满扣
    */
    private Byte couponType;

    /**
    * 限定金额
    */
    private BigDecimal overLimit;

    /**
    * 描述
    */
    private String remark;

    /**
    * 是否使用
    */
    private Byte isUse;

    /**
    * 创建时间
    */
    private String createTime;

    private Long fontUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public BigDecimal getOverLimit() {
        return overLimit;
    }

    public void setOverLimit(BigDecimal overLimit) {
        this.overLimit = overLimit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getFontUserId() {
        return fontUserId;
    }

    public void setFontUserId(Long fontUserId) {
        this.fontUserId = fontUserId;
    }
}