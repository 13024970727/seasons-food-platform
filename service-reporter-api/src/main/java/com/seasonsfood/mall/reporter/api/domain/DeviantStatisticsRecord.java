package com.seasonsfood.mall.reporter.api.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "deviant_statistics_record")
public class DeviantStatisticsRecord extends DeviantStatisticsRecordKey implements Serializable {
    /**
    * 异常事件数量
    */
    private Integer deviantGoodsNumebr;

    /**
    * 异常订单数量
    */
    private Integer deviantOrderNumber;

    /**
    * 正常订单数量
    */
    private Integer normalOrderNumber;

    /**
    * 异常订单/正常订单
    */
    private BigDecimal deviantRate;

    /**
    * 创建时间
    */
    private Date createTime;

    public Integer getDeviantGoodsNumebr() {
        return deviantGoodsNumebr;
    }

    public void setDeviantGoodsNumebr(Integer deviantGoodsNumebr) {
        this.deviantGoodsNumebr = deviantGoodsNumebr;
    }

    public Integer getDeviantOrderNumber() {
        return deviantOrderNumber;
    }

    public void setDeviantOrderNumber(Integer deviantOrderNumber) {
        this.deviantOrderNumber = deviantOrderNumber;
    }

    public Integer getNormalOrderNumber() {
        return normalOrderNumber;
    }

    public void setNormalOrderNumber(Integer normalOrderNumber) {
        this.normalOrderNumber = normalOrderNumber;
    }

    public BigDecimal getDeviantRate() {
        return deviantRate;
    }

    public void setDeviantRate(BigDecimal deviantRate) {
        this.deviantRate = deviantRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}