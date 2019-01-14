package com.seasonsfood.mall.delivery.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "area")
public class  Area implements Serializable {
    private static final long serialVersionUID = 7481120599611207869L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 区域名字
    */
    private String areaName;

    /**
     * 区域类型
     */
    private Short areaType;

    /**
    * 直接上级区域
    */
    private Long parentId;

    /**
    * 所有上级区域，格式 0/1/2
    */
    private String parentIds;

    /**
    * 描述
    */
    private String description;

    /**
    * 排序编号
    */
    private Integer sortNumber;

    /**
    * 是否启用
    */
    private Byte isUse;

    /**
    * 地区系数（预留字段）
    */
    private String areaParam;

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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    public String getAreaParam() {
        return areaParam;
    }

    public void setAreaParam(String areaParam) {
        this.areaParam = areaParam;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getAreaType() {
        return areaType;
    }

    public void setAreaType(Short areaType) {
        this.areaType = areaType;
    }
}