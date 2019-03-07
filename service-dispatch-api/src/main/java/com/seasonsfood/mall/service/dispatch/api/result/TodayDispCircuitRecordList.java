package com.seasonsfood.mall.service.dispatch.api.result;

import java.io.Serializable;
import java.math.BigDecimal;

public class TodayDispCircuitRecordList  implements Serializable {
    private Long dispatchId;//配送员id
    private String dispatchName;//配送员
    private String circuitName;//线路名称
    private Integer orderTotalNum;//订单总数
    private BigDecimal orderTotalMoney;//订单总金额
    private Integer dispDistance;//配送距离
    public TodayDispCircuitRecordList(){
        super();
    }

    public Long getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getDispatchName() {
        return dispatchName;
    }

    public void setDispatchName(String dispatchName) {
        this.dispatchName = dispatchName;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public Integer getOrderTotalNum() {
        return orderTotalNum;
    }

    public void setOrderTotalNum(Integer orderTotalNum) {
        this.orderTotalNum = orderTotalNum;
    }

    public BigDecimal getOrderTotalMoney() {
        return orderTotalMoney;
    }

    public void setOrderTotalMoney(BigDecimal orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }


    public Integer getDispDistance() {
        return dispDistance;
    }

    public void setDispDistance(Integer dispDistance) {
        this.dispDistance = dispDistance;
    }

    @Override
    public String toString() {
        return "TodayDispCircuitRecordList{" +
                "dispatchId='" + dispatchId + '\'' +
                "dispatchName='" + dispatchName + '\'' +
                ", circuitName='" + circuitName + '\'' +
                ", orderTotalNum=" + orderTotalNum +
                ", orderTotalMoney=" + orderTotalMoney +
                ", dispDistance=" + dispDistance +
                '}';
    }
}
