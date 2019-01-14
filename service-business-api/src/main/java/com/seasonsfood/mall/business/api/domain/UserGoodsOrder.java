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
@Table(name = "user_goods_order")
public class UserGoodsOrder implements Serializable {

    private static final long serialVersionUID = 6517060325111795797L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 前端用户ID
    */
    private Long fontUserId;

    /**
    * 外送员用户ID
    */
    private Long deliveryUserId;

    /**
    * 总费用
    */
    private BigDecimal totalPay;

    /**
    * 预定时间
    */
    private Date orderTime;

    /**
    * 备注
    */
    private String remark;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 订单来源 1 app 2 小程序
    */
    private Short orderFrom;

    /**
    * 外送图片
    */
    private String deliveryPicture;

    /**
    * 配送排序
    */
    private Short deliverySort;

    /**
    * 配送组别
    */
    private Byte deliveryGroup;

    /**
    * 配送方式 1 平台配送 2 商家配送
    */
    private String deliveryType;

    /**
    * 外送地址
    */
    private String dliveryAddress;

    /**
    * 外送费用(统一)
    */
    private BigDecimal deliveryFee;

    /**
    * 配送费用（额外）
    */
    private BigDecimal deliveryExtraFee;

    /**
    * 状态  1 待付款  2 备货中 3  待配送 4 待收货  5 待评价
    */
    private Byte status;

    /**
    * 付款类型 1  预付款 2 货到付款
    */
    private Byte payType;

    /**
    * 订单异常率  此异常商品/此订单总商品
    */
    private BigDecimal deviantRate;

    /**
    * 分拣员用户ID
    */
    private Long tillerUserId;

    /**
    * 地址ID

    */
    private Long addressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFontUserId() {
        return fontUserId;
    }

    public void setFontUserId(Long fontUserId) {
        this.fontUserId = fontUserId;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public Short getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Short orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getDeliveryPicture() {
        return deliveryPicture;
    }

    public void setDeliveryPicture(String deliveryPicture) {
        this.deliveryPicture = deliveryPicture;
    }

    public Short getDeliverySort() {
        return deliverySort;
    }

    public void setDeliverySort(Short deliverySort) {
        this.deliverySort = deliverySort;
    }

    public Byte getDeliveryGroup() {
        return deliveryGroup;
    }

    public void setDeliveryGroup(Byte deliveryGroup) {
        this.deliveryGroup = deliveryGroup;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDliveryAddress() {
        return dliveryAddress;
    }

    public void setDliveryAddress(String dliveryAddress) {
        this.dliveryAddress = dliveryAddress;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getDeliveryExtraFee() {
        return deliveryExtraFee;
    }

    public void setDeliveryExtraFee(BigDecimal deliveryExtraFee) {
        this.deliveryExtraFee = deliveryExtraFee;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public BigDecimal getDeviantRate() {
        return deviantRate;
    }

    public void setDeviantRate(BigDecimal deviantRate) {
        this.deviantRate = deviantRate;
    }

    public Long getTillerUserId() {
        return tillerUserId;
    }

    public void setTillerUserId(Long tillerUserId) {
        this.tillerUserId = tillerUserId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}