package com.seasonsfood.mall.service.dispatch.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 配送员每天配送线路
 */
@Table(name="disp_dispatch_circuit")
public class DispDispatchCircuit implements Serializable {

    @Id
    private Long id;//配送员实际线路id
    private String dispatchName;//配送员
    private Long dispatchId;//配送员id
    private Long dispCircuitRecordId;
    private String lngLatCircuit;//经纬度-线路
    private Integer isDel;//是否删除：1是 0否
    private Date createTime;//创建时间

    public DispDispatchCircuit() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDispatchName() {
        return dispatchName;
    }

    public void setDispatchName(String dispatchName) {
        this.dispatchName = dispatchName;
    }

    public Long getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
    }

    public Long getDispCircuitRecordId() {
        return dispCircuitRecordId;
    }

    public void setDispCircuitRecordId(Long dispCircuitRecordId) {
        this.dispCircuitRecordId = dispCircuitRecordId;
    }

    public String getLngLatCircuit() {
        return lngLatCircuit;
    }

    public void setLngLatCircuit(String lngLatCircuit) {
        this.lngLatCircuit = lngLatCircuit;
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
        return "DispDispatchCircuit{" +
                "id=" + id +
                ", dispatchName='" + dispatchName + '\'' +
                ", dispatchId=" + dispatchId +
                ", dispCircuitRecordId=" + dispCircuitRecordId +
                ", lngLatCircuit='" + lngLatCircuit + '\'' +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                '}';
    }
}
