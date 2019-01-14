package com.seasonsfood.mall.reporter.api.domain;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
public class DeviantStatisticsRecordKey implements Serializable {
    private static final long serialVersionUID = 3497389061617068850L;
    /**
    * 异常时间id
    */
    @Id
    private Long deviantStatuId;

    /**
    * 记录时间精确到天  一个异常事件一天一个统计记录
    */
    @Id
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