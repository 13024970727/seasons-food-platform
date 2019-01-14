package com.seasonsfood.mall.fontuser.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "font_user_address")
public class FontUserAddress implements Serializable {
    private static final long serialVersionUID = -8593956129940765507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 详细地址
    */
    private String detailAddress;

    /**
    * 是否默认地址
    */
    private Byte isDefault;

    /**
    * 地址类型 1  小区 2 自建房 3 店铺 4 公司 5其他
    */
    private Byte addressType;

    /**
    * 梯号
    */
    private String ladderNumber;

    /**
    * 门牌号
    */
    private String houseNumber;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 排序
    */
    private Short sortNumber;

    /**
    * 用户ID
    */
    private Long fontUserId;

    /**
    * 此地址分配的配送员
    */
    private Long deliveryUserId;

    /**
    * 地区ID
    */
    private Long areaId;

    public FontUserAddress(){}

    public FontUserAddress(Long id,Long deliveryUserId) {
        this.id = id;
        this.deliveryUserId = deliveryUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Byte getAddressType() {
        return addressType;
    }

    public void setAddressType(Byte addressType) {
        this.addressType = addressType;
    }

    public String getLadderNumber() {
        return ladderNumber;
    }

    public void setLadderNumber(String ladderNumber) {
        this.ladderNumber = ladderNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Short sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Long getFontUserId() {
        return fontUserId;
    }

    public void setFontUserId(Long fontUserId) {
        this.fontUserId = fontUserId;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}