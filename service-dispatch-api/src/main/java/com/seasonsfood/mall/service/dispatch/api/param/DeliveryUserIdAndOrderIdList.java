package com.seasonsfood.mall.service.dispatch.api.param;

import java.io.Serializable;
import java.util.List;

public class DeliveryUserIdAndOrderIdList implements Serializable {
  private   List<DeliveryUserIdAndOrderId> deliveryUserIdAndOrderIdList;
    public DeliveryUserIdAndOrderIdList(){super();}
    public List<DeliveryUserIdAndOrderId> getDeliveryUserIdAndOrderIdList() {
        return deliveryUserIdAndOrderIdList;
    }

    public void setDeliveryUserIdAndOrderIdList(List<DeliveryUserIdAndOrderId> deliveryUserIdAndOrderIdList) {
        this.deliveryUserIdAndOrderIdList = deliveryUserIdAndOrderIdList;
    }

    @Override
    public String toString() {
        return "DeliveryUserIdAndOrderIdList{" +
                "deliveryUserIdAndOrderIdList=" + deliveryUserIdAndOrderIdList +
                '}';
    }
}
