package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author ron
 */
public class TillerRecordKey {
    /**
    * 分拣员id
    */
    @Id
    private Long sysUserId;

    /**
    * 记录时间，记录到天
    */
    @Id
    private Date recordTime;

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}