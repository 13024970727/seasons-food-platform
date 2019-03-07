package com.seasonsfood.mall.service.dispatch.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 配送员每天配送记录
 */
@Table(name="disp_circuit_record")
public class DispCircuitRecord implements Serializable {

    @Id
    private Long id;//配送线路记录id
    private String circuitName;//线路名称
    private Long circuitId;//配送线路id
    private Integer circuitOrderly;//线路序号
    private Integer dispatchOrderly;//配送员序号
    private String lngLatCircuit;//线路经纬度 格式：地点序号:经度,纬度;
    private Long dispatchId;//配送员id
    private String dispatchName;//配送员
    private Integer dispStatus;//配送状态：1待配送 2配送中 3配送结束
    private Date dispStartTime;//配送开始时间
    private Date dispEndTime;//配送结束时间
    private Integer alreadyDispNum;//已配送数
    private Integer notDispNum;//未配送数
    private Integer circuitAlike;//线路吻合度
    private Integer orderTotalNum;//订单总数
    private BigDecimal orderTotalMoney;//订单总金额
    private Integer dispDistance;//配送距离
    private Integer isDel;//是否删除：1是 0否
    private Date createTime;//创建时间

    public DispCircuitRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public Long getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(Long circuitId) {
        this.circuitId = circuitId;
    }

    public Integer getCircuitOrderly() {
        return circuitOrderly;
    }

    public void setCircuitOrderly(Integer circuitOrderly) {
        this.circuitOrderly = circuitOrderly;
    }

    public Integer getDispatchOrderly() {
        return dispatchOrderly;
    }

    public void setDispatchOrderly(Integer dispatchOrderly) {
        this.dispatchOrderly = dispatchOrderly;
    }

    public String getLngLatCircuit() {
        return lngLatCircuit;
    }

    public void setLngLatCircuit(String lngLatCircuit) {
        this.lngLatCircuit = lngLatCircuit;
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

    public Integer getDispStatus() {
        return dispStatus;
    }

    public void setDispStatus(Integer dispStatus) {
        this.dispStatus = dispStatus;
    }

    public Date getDispStartTime() {
        return dispStartTime;
    }

    public void setDispStartTime(Date dispStartTime) {
        this.dispStartTime = dispStartTime;
    }

    public Date getDispEndTime() {
        return dispEndTime;
    }

    public void setDispEndTime(Date dispEndTime) {
        this.dispEndTime = dispEndTime;
    }

    public Integer getAlreadyDispNum() {
        return alreadyDispNum;
    }

    public void setAlreadyDispNum(Integer alreadyDispNum) {
        this.alreadyDispNum = alreadyDispNum;
    }

    public Integer getNotDispNum() {
        return notDispNum;
    }

    public void setNotDispNum(Integer notDispNum) {
        this.notDispNum = notDispNum;
    }

    public Integer getCircuitAlike() {
        return circuitAlike;
    }

    public void setCircuitAlike(Integer circuitAlike) {
        this.circuitAlike = circuitAlike;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DispCircuitRecord{" +
                "id=" + id +
                ", circuitName='" + circuitName + '\'' +
                ", circuitId=" + circuitId +
                ", circuitOrderly=" + circuitOrderly +
                ", dispatchOrderly=" + dispatchOrderly +
                ", lngLatCircuit='" + lngLatCircuit + '\'' +
                ", dispatchId=" + dispatchId +
                ", dispatchName='" + dispatchName + '\'' +
                ", dispStatus=" + dispStatus +
                ", dispStartTime=" + dispStartTime +
                ", dispEndTime=" + dispEndTime +
                ", alreadyDispNum=" + alreadyDispNum +
                ", notDispNum=" + notDispNum +
                ", circuitAlike=" + circuitAlike +
                ", orderTotalNum=" + orderTotalNum +
                ", orderTotalMoney=" + orderTotalMoney +
                ", dispDistance=" + dispDistance +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                '}';
    }
}
