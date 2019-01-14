package com.seasonsfood.mall.delivery.api.domain;

import java.io.Serializable;
import java.util.Date;

public class DeviantStatisticsRecordKey implements Serializable {
    /**
    * 异常时间id
    */
    private Long deviantStatuId;

    /**
    * 记录时间精确到天  一个异常事件一天一个统计记录
    */
    private Date recordTime;

    public Long getDeviantStatuId() {
        return deviantStatuId;
    }

    public void setDeviantStatuId(Long deviantStatuId) {
        this.deviantStatuId = deviantStatuId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}