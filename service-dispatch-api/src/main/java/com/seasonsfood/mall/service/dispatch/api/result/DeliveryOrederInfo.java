package com.seasonsfood.mall.service.dispatch.api.result;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jiangchengwei
 * @date 2019-03-08-09:15
 */
public class DeliveryOrederInfo implements Serializable {
    private Long orderId;//订单编号
    private Long id;//用户账号
    private Long deliveryUserId;//用户账号
    private String userName;//用户姓名
    private String areaName;//区域
    private String address;//地址
    private String dispatchName;//配送员
    private String state;//配送状态
    private Integer status;//配送状态
    private String deliveryPicture;//配送图片
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receiveTime;

    public DeliveryOrederInfo() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDispatchName() {
        return dispatchName;
    }

    public void setDispatchName(String dispatchName) {
        this.dispatchName = dispatchName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeliveryPicture() {
        return deliveryPicture;
    }

    public void setDeliveryPicture(String deliveryPicture) {
        this.deliveryPicture = deliveryPicture;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public String toString() {
        return "DeliveryOrederInfo{" +
                "orderId=" + orderId +
                ", id=" + id +
                ", deliveryUserId=" + deliveryUserId +
                ", userName='" + userName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", address='" + address + '\'' +
                ", dispatchName='" + dispatchName + '\'' +
                ", state='" + state + '\'' +
                ", status='" + status + '\'' +
                ", deliveryPicture='" + deliveryPicture + '\'' +
                ", receiveTime=" + receiveTime +
                '}';
    }
}
