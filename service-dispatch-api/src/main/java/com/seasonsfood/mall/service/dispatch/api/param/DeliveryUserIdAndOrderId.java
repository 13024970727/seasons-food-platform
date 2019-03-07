package com.seasonsfood.mall.service.dispatch.api.param;

import java.io.Serializable;

public class DeliveryUserIdAndOrderId implements Serializable {
   private Long  deliveryUserId;
   private  Long orderId;
    public DeliveryUserIdAndOrderId(){super();}
    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "DeliveryUserIdAndOrderId{" +
                "deliveryUserId=" + deliveryUserId +
                ", orderId=" + orderId +
                '}';
    }
}
