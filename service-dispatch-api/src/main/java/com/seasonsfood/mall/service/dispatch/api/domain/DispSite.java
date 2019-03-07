package com.seasonsfood.mall.service.dispatch.api.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "disp_site")
public class DispSite implements Serializable {
    @Id
    private Long id;
    private String siteName;//地点名称
    private Long parentStreetId;//上级街道id
    private Double lng;//经度
    private Double lat;//纬度
    private Integer isDel;//是否删除
    private Integer isStart;//是否启用
    @OrderBy("asc")
    private Long sortNumber;
    private Integer registerUserNum;//注册用户数量
    private Integer buyUserNum;//购买用户数量

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间


    public DispSite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Long getParentStreetId() {
        return parentStreetId;
    }

    public void setParentStreetId(Long parentStreetId) {
        this.parentStreetId = parentStreetId;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRegisterUserNum() {
        return registerUserNum;
    }

    public void setRegisterUserNum(Integer registerUserNum) {
        this.registerUserNum = registerUserNum;
    }

    public Long getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Long sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Integer getBuyUserNum() {
        return buyUserNum;
    }

    public void setBuyUserNum(Integer buyUserNum) {
        this.buyUserNum = buyUserNum;
    }

    @Override
    public String toString() {
        return "DispSite{" +
                "id=" + id +
                ", siteName='" + siteName + '\'' +
                ", parentStreetId=" + parentStreetId +
                ", lng=" + lng +
                ", lat=" + lat +
                ", isDel=" + isDel +
                ", isStart=" + isStart +
                ", sortNumber=" + sortNumber +
                ", registerUserNum=" + registerUserNum +
                ", buyUserNum=" + buyUserNum +
                ", createTime=" + createTime +
                '}';
    }
}
