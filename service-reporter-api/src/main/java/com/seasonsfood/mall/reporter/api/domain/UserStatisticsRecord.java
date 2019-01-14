package com.seasonsfood.mall.reporter.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "user_statistics_record")
public class UserStatisticsRecord implements Serializable {
    private static final long serialVersionUID = 3348937451037396181L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 精确到天
    */
    private Date recordDate;

    /**
    * 注册用户数量
    */
    private Integer registerNumber;

    /**
    * 有下单购买用户数
    */
    private Integer buyUserNumber;

    /**
    * 当前平台用户数
    */
    private Integer platformTotalNumber;

    /**
    * 创建时间
    */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Integer getBuyUserNumber() {
        return buyUserNumber;
    }

    public void setBuyUserNumber(Integer buyUserNumber) {
        this.buyUserNumber = buyUserNumber;
    }

    public Integer getPlatformTotalNumber() {
        return platformTotalNumber;
    }

    public void setPlatformTotalNumber(Integer platformTotalNumber) {
        this.platformTotalNumber = platformTotalNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}