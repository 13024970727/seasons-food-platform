package com.seasonsfood.mall.business.api.result;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//出库记录
@Table(name="goods_stock_out_record")
public class GoodsStockOutRecordResult implements Serializable {

    @Id
    private Long id;
    /**
     *记录时间
     */
    private String writeTime;
    /**
     *类型
     */
    private String type;
    /**
     *类型名称
     */
    private Byte typeNum;
    /**
     *数量
     */
    private BigDecimal number;
    /**
     *执行人
     */
    private String executorName;
    /**
     * 备注
     */
    private String remark;

    public GoodsStockOutRecordResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Byte getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Byte typeNum) {
        this.typeNum = typeNum;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "GoodsStockOutRecordResult{" +
                "id=" + id +
                ", writeTime='" + writeTime + '\'' +
                ", type='" + type + '\'' +
                ", typeNum='" + typeNum + '\'' +
                ", number=" + number +
                ", executorName='" + executorName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
