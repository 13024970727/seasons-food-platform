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
@Table(name = "shop_goods_order")
public class ShopGoodsOrder implements Serializable {

    private static final long serialVersionUID = 7039496199943833074L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 商家ID
    */
    private Long shopBaseInfoId;

    /**
    * 用户订单ID，用户订单和商户订单为1对多关系，一个用户订单由多个商户配送
    */
    private Long userGoodsOrderId;

    /**
    * 状态  1 确认 2 待确认
    */
    private Byte status;

    /**
    * 订单流水号
    */
    private String orderNumber;

    /**
    * 预定日期

    */
    private Date orderTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 订单总金额
    */
    private BigDecimal totalMoney;

    /**
    * 返点扣减金额,结算时应该减去此金额
    */
    private BigDecimal rebateMoney;

    /**
    * 结算金额

    */
    private BigDecimal settleMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }

    public Long getUserGoodsOrderId() {
        return userGoodsOrderId;
    }

    public void setUserGoodsOrderId(Long userGoodsOrderId) {
        this.userGoodsOrderId = userGoodsOrderId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getRebateMoney() {
        return rebateMoney;
    }

    public void setRebateMoney(BigDecimal rebateMoney) {
        this.rebateMoney = rebateMoney;
    }

    public BigDecimal getSettleMoney() {
        return settleMoney;
    }

    public void setSettleMoney(BigDecimal settleMoney) {
        this.settleMoney = settleMoney;
    }
}