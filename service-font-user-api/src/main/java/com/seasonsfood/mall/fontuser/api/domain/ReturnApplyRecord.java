package com.seasonsfood.mall.fontuser.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ron
 */
@Table(name = "return_apply_record")
public class ReturnApplyRecord implements Serializable {
    private static final long serialVersionUID = 2791448001356882714L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 申请用户ID
    */
    private Long fontUserId;

    /**
    * 退货商品
    */
    private Long goodsId;

    /**
    * 退货订单
    */
    private Long goodsOrderId;

    /**
    * 退款金额
    */
    private BigDecimal returnMoney;

    /**
    * 退款金额

    */
    private String returnReason;

    /**
    * 状态  1 申请中 2 同意 3 拒绝
    */
    private String status;

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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(Long goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}