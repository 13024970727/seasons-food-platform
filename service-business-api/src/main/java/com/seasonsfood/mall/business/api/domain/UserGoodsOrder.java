package com.seasonsfood.mall.business.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ron
 */
@Table(name = "user_goods_order")
public class  UserGoodsOrder implements Serializable {

    /**
     * 显示状态
     * 1 待配送
     */

    public static final Byte SHOW_STATE_WAIT_FOR_PEND = 1;
    /**
     * 显示状态
     * 2 配送中
     */
    public static final Byte SHOW_STATE_PENDING = 2;
    /**
     * 显示状态
     * 3待评价
     */
    public static final Byte SHOW_STATE_RECEIVED = 3;
    /**
     * 显示状态
     * 4售前售后
     */
    public static final Byte SHOW_STATE_RETURN = 4;
    /**
     * 显示状态
     * 5已完成
     */
    public static final Byte SHOW_STATE_FINISH = 5;
    /**
     * 订单状态
     * 1 待配送（未处理）
     */

    public static final Byte ORDER_STATE_WAIT_FOR_PEND = 11;
    /**
     * 订单状态
     * 2 待配送（备货中）
     */
    public static final Byte ORDER_STATE_PENDING = 12;
    /**
     * 订单状态
     * 3待配送（分拣中）
     */
    public static final Byte ORDER_STATE_SORTING = 13;
    /**
     * 订单状态
     * 4配送中
     */
    public static final Byte ORDER_STATE_DELIVERYING = 21;
    /**
     * 订单状态
     * 5已送达
     */
    public static final Byte ORDER_STATE_DELIVERED = 22;
    /**
     * 订单状态
     * 6已收货 （待评价）
     */
    public static final Byte ORDER_STATE_RECEIVED = 31;
    /**
     * 订单状态
     * 7评价完成
     */
    public static final Byte ORDER_STATE_COMMENT = 51;
    /**
     * 订单状态
     * 8退货中
     */
    public static final Byte ORDER_STATE_RETURNING = 41;
    /**
     * 订单状态
     * 9退货完成
     */
    public static final Byte ORDER_STATE_RETURNED = 42;


    /**
     * 订单支付方式
     */
    public static final Byte PAY_TYPE_ADVANCE = 1;

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
    private Byte orderFrom;

    /**
     * 外送到达图片
     */
    private String deliveryPicture;

    /**
     * 配送排序
     */
    private Short deliverySort;

    /**
     * 配送组别
     */
    private Short deliveryGroup;

    /**
     * 外送地址
     */
    private String deliveryAddress;

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
     * 是否异常订单 true 异常订单 false非异常订单
     */
    private Boolean abnomal;

    /**
     * 订单优惠券id
     */
    private Long couponId;
    /**
     * 订单优惠金额
     */
    private BigDecimal couponFee;

    /**
     * 开始配送时间
     */
    private Date deliveryTime;
    /**
     * 送达时间
     */
    private Date receiveTime;
    /**
     * 确认收货时间
     */
    private Date confirmTime;
    /**
     * 退货时间
     */
    private Date returnTime;
    /**
     * 订单展示状态
     */
    private Byte showStatus;
    /**
     * 订单最后金额
     */
    private BigDecimal orderFinalPay;
    /**
     * 地点id
     */
    private Long siteId;
    /**id
     * 线路
     */
    private Long circuitId;
    /**
     * 商品列表
     */
    private List<GoodsOrderHasGoods> goodsList;


    public UserGoodsOrder() {
        this.createTime = new Date();
    }

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

    public Byte getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Byte orderFrom) {
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

    public Short getDeliveryGroup() {
        return deliveryGroup;
    }

    public void setDeliveryGroup(Short deliveryGroup) {
        this.deliveryGroup = deliveryGroup;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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

    public Boolean getAbnomal() {
        return abnomal;
    }

    public void setAbnomal(Boolean abnomal) {
        this.abnomal = abnomal;
    }

    public BigDecimal getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(BigDecimal couponFee) {
        this.couponFee = couponFee;
    }

    public List<GoodsOrderHasGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsOrderHasGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Byte getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Byte showStatus) {
        this.showStatus = showStatus;
    }

    public BigDecimal getOrderFinalPay() {
        return orderFinalPay;
    }

    public void setOrderFinalPay(BigDecimal orderFinalPay) {
        this.orderFinalPay = orderFinalPay;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(Long circuitId) {
        circuitId = circuitId;
    }

    @Override
    public String toString() {
        return "UserGoodsOrder{" +
                "id=" + id +
                ", fontUserId=" + fontUserId +
                ", deliveryUserId=" + deliveryUserId +
                ", totalPay=" + totalPay +
                ", orderTime=" + orderTime +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", orderFrom=" + orderFrom +
                ", deliveryPicture='" + deliveryPicture + '\'' +
                ", deliverySort=" + deliverySort +
                ", deliveryGroup=" + deliveryGroup +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryFee=" + deliveryFee +
                ", deliveryExtraFee=" + deliveryExtraFee +
                ", status=" + status +
                ", payType=" + payType +
                ", deviantRate=" + deviantRate +
                ", tillerUserId=" + tillerUserId +
                ", abnomal=" + abnomal +
                ", couponId=" + couponId +
                ", couponFee=" + couponFee +
                ", deliveryTime=" + deliveryTime +
                ", receiveTime=" + receiveTime +
                ", confirmTime=" + confirmTime +
                ", returnTime=" + returnTime +
                ", showStatus=" + showStatus +
                ", orderFinalPay=" + orderFinalPay +
                ", siteId=" + siteId +
                ", circuitId=" + circuitId +
                ", goodsList=" + goodsList +
                '}';
    }
}