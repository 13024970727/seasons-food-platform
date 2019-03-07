package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//出入库记录表
@Table(name="goods_stock_out_record")
public class GoodsStockOutRecord implements Serializable {

    @Id
    private Long id;
    private Date writeTime;
    private Byte type;//1入库2/售出/3破损/退货
    private BigDecimal number;
    private Long executorId;
    private Long checkId;
    private String remark;

    public GoodsStockOutRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "GoodsStockOutRecord{" +
                "id=" + id +
                ", writeTime=" + writeTime +
                ", type=" + type +
                ", number=" + number +
                ", executorId=" + executorId +
                ", checkId=" + checkId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
