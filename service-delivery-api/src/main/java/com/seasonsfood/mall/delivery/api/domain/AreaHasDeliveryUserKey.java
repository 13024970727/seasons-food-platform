package com.seasonsfood.mall.delivery.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "area_has_delivery_user")
public class AreaHasDeliveryUserKey implements Serializable {
    private static final long serialVersionUID = 8597949346852332718L;
    /**
    * 地区id
    */
    @Id
    private Long areaId;

    /**
    * 外送员id
    */
    @Id
    private Long deliveryUserId;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }
}