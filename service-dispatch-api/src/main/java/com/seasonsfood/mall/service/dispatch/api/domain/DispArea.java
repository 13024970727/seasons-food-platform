package com.seasonsfood.mall.service.dispatch.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "disp_area")
public class DispArea implements Serializable {

    /**
     * 省
     */
    public static final Integer TYPE_PROVINCE = 1;

    /**
     * 市
     */
    public static final Integer TYPE_CITY = 2;

    /**
     * 区/县
     */
    public static final Integer TYPE_COUNTY = 3;

    /**
     * 区域/街道
     */
    public static final Integer TYPE_STREET = 4;

    @Id
    private Long id;
    private String areaName;//区域名字
    private Integer areaType;//区域类型
    private Long parentId;//直接上级区域
    private String parentIds;//所有上级区域,格式0/1/2/3
    private String description;//描述
    @OrderBy("asc")
    private Integer sortNumber;//排序
    private Integer childAreaTotalNum;//下级区域启用数量
    private Integer currentAreaRegisterUserNum;//当前区域下注册人数
    private Integer isHasDisp;//是否配送区域
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间


    public DispArea() {
    }


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

    public Integer getAreaType() {

        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
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

    public Integer getChildAreaTotalNum() {
        return childAreaTotalNum;
    }

    public void setChildAreaTotalNum(Integer childAreaTotalNum) {
        this.childAreaTotalNum = childAreaTotalNum;
    }

    public Integer getCurrentAreaRegisterUserNum() {
        return currentAreaRegisterUserNum;
    }

    public void setCurrentAreaRegisterUserNum(Integer currentAreaRegisterUserNum) {
        this.currentAreaRegisterUserNum = currentAreaRegisterUserNum;
    }

    public Integer getIsHasDisp() {
        return isHasDisp;
    }

    public void setIsHasDisp(Integer isHasDisp) {
        this.isHasDisp = isHasDisp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    @Override
    public String toString() {
        return "DispArea{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                ", areaType=" + areaType +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", description='" + description + '\'' +
                ", sortNumber=" + sortNumber +
                ", childAreaTotalNum=" + childAreaTotalNum +
                ", currentAreaRegisterUserNum=" + currentAreaRegisterUserNum +
                ", isHasDisp=" + isHasDisp +
                ", createTime=" + createTime +
                '}';
    }
}
