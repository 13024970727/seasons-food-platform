package com.seasonsfood.mall.service.dispatch.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Table;
import java.util.Date;
@Table(name="disp_site_unit")
public class DispSiteUnit {

    private Long id;//地点细分单元id
    private String siteUnitName;//地点单元名称
    private Long parentSiteId;//上级地点id
    private Integer registerUserNum;//注册用户数量
    private Integer buyUseNum;//购买用户数量
    private Integer isStart;//是否启用：1是 0否
    private Integer isDel;//是否删除：1是 0否
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

    public DispSiteUnit() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteUnitName() {
        return siteUnitName;
    }

    public void setSiteUnitName(String siteUnitName) {
        this.siteUnitName = siteUnitName;
    }

    public Long getParentSiteId() {
        return parentSiteId;
    }

    public void setParentSiteId(Long parentSiteId) {
        this.parentSiteId = parentSiteId;
    }

    public Integer getRegisterUserNum() {
        return registerUserNum;
    }

    public void setRegisterUserNum(Integer registerUserNum) {
        this.registerUserNum = registerUserNum;
    }

    public Integer getBuyUseNum() {
        return buyUseNum;
    }

    public void setBuyUseNum(Integer buyUseNum) {
        this.buyUseNum = buyUseNum;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DispSiteUnit{" +
                "id=" + id +
                ", siteUnitName='" + siteUnitName + '\'' +
                ", parentSiteId=" + parentSiteId +
                ", registerUserNum=" + registerUserNum +
                ", buyUseNum=" + buyUseNum +
                ", isStart=" + isStart +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                '}';
    }
}
