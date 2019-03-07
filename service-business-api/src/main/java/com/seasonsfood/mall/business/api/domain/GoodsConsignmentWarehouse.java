package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "goods_consignment_warehouse")
public class GoodsConsignmentWarehouse implements Serializable {


    @Id
    private Integer warehouseId;

    private String warehouseName;

    private Byte stateId;

    public GoodsConsignmentWarehouse() {
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Byte getStateId() {
        return stateId;
    }

    public void setStateId(Byte stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "goodsConsignmentWarehouse{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", stateId=" + stateId +
                '}';
    }
}
