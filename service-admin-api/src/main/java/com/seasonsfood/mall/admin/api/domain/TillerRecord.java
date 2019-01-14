package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "tiller_record")
public class TillerRecord extends TillerRecordKey {
    /**
    * 分拣数量
    */
    private Integer tillerNumber;

    /**
    * 开始时间
    */
    private String startTime;

    /**
    * 结束时间
    */
    private String endTime;

    /**
    * 效率
    */
    private BigDecimal efficient;

    /**
    * 分捡金额
    */
    private BigDecimal tillerOrderValue;

    /**
    * 创建时间
    */
    private Date createTime;

    public Integer getTillerNumber() {
        return tillerNumber;
    }

    public void setTillerNumber(Integer tillerNumber) {
        this.tillerNumber = tillerNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getEfficient() {
        return efficient;
    }

    public void setEfficient(BigDecimal efficient) {
        this.efficient = efficient;
    }

    public BigDecimal getTillerOrderValue() {
        return tillerOrderValue;
    }

    public void setTillerOrderValue(BigDecimal tillerOrderValue) {
        this.tillerOrderValue = tillerOrderValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}