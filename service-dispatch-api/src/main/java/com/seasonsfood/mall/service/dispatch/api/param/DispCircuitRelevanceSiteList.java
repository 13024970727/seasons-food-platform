package com.seasonsfood.mall.service.dispatch.api.param;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;

import java.io.Serializable;
import java.util.List;

public class DispCircuitRelevanceSiteList implements Serializable {
    private  List<DispCircuitRelevanceSite> dispCircuitRelevanceSite;
    public DispCircuitRelevanceSiteList(){
        super();
    }

    public List<DispCircuitRelevanceSite> getDispCircuitRelevanceSite() {
        return dispCircuitRelevanceSite;
    }

    public void setDispCircuitRelevanceSite(List<DispCircuitRelevanceSite> dispCircuitRelevanceSite) {
        this.dispCircuitRelevanceSite = dispCircuitRelevanceSite;
    }

    @Override
    public String toString() {
        return "DispCircuitRelevanceSiteList{" +
                "dispCircuitRelevanceSite=" + dispCircuitRelevanceSite +
                '}';
    }
}
