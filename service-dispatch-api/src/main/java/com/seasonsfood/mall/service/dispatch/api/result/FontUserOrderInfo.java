package com.seasonsfood.mall.service.dispatch.api.result;

import java.io.Serializable;

public class FontUserOrderInfo implements Serializable {
    private Long orderId;//订单编号
    private Long id;//用户账号
    private String userName;//用户名
    private String realName;//用户真实姓名
    private String deliveryAddress;//配送地址
    private Long phone;//手机号码
    public FontUserOrderInfo(){
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "FontUserOrderInfo{" +
                "orderId=" + orderId +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", phone=" + phone +
                '}';
    }
}
