package com.seasonsfood.mall.service.dispatch.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 配送主干线路
 */
@Table(name="disp_circuit")
public class DispCircuit implements Serializable {

    @Id
    private Long id; //线路id
    private String circuitName;//线路名称
    private Long dispatchId;//配送员id
    private String dispatchName;//配送员
    private Integer circuitOrderly;//线路序号
    private Integer dispatchOrderly;//配送序号
    private Integer dispDistance;//配送距离
    private Integer dispSiteNum;//配送地点总数
    private Integer registerUserNum;//注册用户总数
    private Integer isDel;//是否删除:1删除  0未删除
    private Date createTime;//创建时间

    public DispCircuit() {
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

    public Integer getDispDistance() {
        return dispDistance;
    }

    public void setDispDistance(Integer dispDistance) {
        this.dispDistance = dispDistance;
    }

    public Integer getDispSiteNum() {
        return dispSiteNum;
    }

    public void setDispSiteNum(Integer dispSiteNum) {
        this.dispSiteNum = dispSiteNum;
    }

    public Integer getRegisterUserNum() {
        return registerUserNum;
    }

    public void setRegisterUserNum(Integer registerUserNum) {
        this.registerUserNum = registerUserNum;
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
        return "DispCircuit{" +
                "id=" + id +
                ", circuitName='" + circuitName + '\'' +
                ", dispatchId=" + dispatchId +
                ", dispatchName='" + dispatchName + '\'' +
                ", circuitOrderly=" + circuitOrderly +
                ", dispatchOrderly=" + dispatchOrderly +
                ", dispDistance=" + dispDistance +
                ", dispSiteNum=" + dispSiteNum +
                ", registerUserNum=" + registerUserNum +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                '}';
    }
}
