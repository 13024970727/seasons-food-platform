package com.seasonsfood.mall.service.dispatch.api.param;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import java.io.Serializable;
import java.util.List;

public class DispCircuitList implements Serializable {
    private  List<DispCircuit> dispCircuit;
    public DispCircuitList(){
        super();
    }
    public List<DispCircuit> getDispCircuit() {
        return dispCircuit;
    }

    public void setDispCircuit(List<DispCircuit> dispCircuit) {
        this.dispCircuit = dispCircuit;
    }

    @Override
    public String toString() {
        return "DispCircuitRecordList{" +
                "dispCircuit=" + dispCircuit +
                '}';
    }
}
