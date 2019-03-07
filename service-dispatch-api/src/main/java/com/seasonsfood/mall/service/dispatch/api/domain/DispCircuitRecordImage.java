package com.seasonsfood.mall.service.dispatch.api.domain;

import java.util.Date;

public class DispCircuitRecordImage {
    private  Long id;//配送记录图片id',
    private String dispImageName;//配送图片名称
    private String dispImageDescr;//配送图片描述
    private String dispImagePath;//配送图片路径
    private String dispCircuitRecordId;//配送记录id
    private  Integer isDel;//是否删除：1是 0否
    private   Date createTime;//创建时间
    public DispCircuitRecordImage() {
        super();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDispImageName() {
        return dispImageName;
    }

    public void setDispImageName(String dispImageName) {
        this.dispImageName = dispImageName;
    }

    public String getDispImageDescr() {
        return dispImageDescr;
    }

    public void setDispImageDescr(String dispImageDescr) {
        this.dispImageDescr = dispImageDescr;
    }

    public String getDispImagePath() {
        return dispImagePath;
    }

    public void setDispImagePath(String dispImagePath) {
        this.dispImagePath = dispImagePath;
    }

    public String getDispCircuitRecordId() {
        return dispCircuitRecordId;
    }

    public void setDispCircuitRecordId(String dispCircuitRecordId) {
        this.dispCircuitRecordId = dispCircuitRecordId;
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
        return "DispCircuitRecordImage{" +
                "id=" + id +
                ", dispImageName='" + dispImageName + '\'' +
                ", dispImageDescr='" + dispImageDescr + '\'' +
                ", dispImagePath='" + dispImagePath + '\'' +
                ", dispCircuitRecordId='" + dispCircuitRecordId + '\'' +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                '}';
    }
}
