package com.seasonsfood.mall.service.dispatch.api.param;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRecord;

import java.io.Serializable;
import java.util.List;

public class DispCircuitRecordList  implements Serializable {
    private  List<DispCircuitRecord> dispCircuitRecord;
    public DispCircuitRecordList(){
        super();
    }
    public List<DispCircuitRecord> getDispCircuitRecord() {
        return dispCircuitRecord;
    }

    public void setDispCircuitRecord(List<DispCircuitRecord> dispCircuitRecord) {
        this.dispCircuitRecord = dispCircuitRecord;
    }

    @Override
    public String toString() {
        return "DispCircuitRecordList{" +
                "dispCircuitRecord=" + dispCircuitRecord +
                '}';
    }
}
