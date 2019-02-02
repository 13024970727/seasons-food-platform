package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="goods_metering_unit")
public class GoodsMeteringUnit implements Serializable {
    @Id
    private Integer unitId;//id

    private String unitName;//名称

    private Byte stateId;//状态1启用,0删除
    public GoodsMeteringUnit() {
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Byte getStateId() {
        return stateId;
    }

    public void setStateId(Byte stateId) {
        this.stateId = stateId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return "MeteringUnit{" +
                "unitId=" + unitId +
                ", unitName='" + unitName + '\'' +
                ", stateId=" + stateId +
                '}';
    }

}
