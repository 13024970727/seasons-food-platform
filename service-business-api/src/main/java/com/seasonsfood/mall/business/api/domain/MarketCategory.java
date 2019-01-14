package com.seasonsfood.mall.business.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * @author ron
 */
@Table(name = "market_category")
public class MarketCategory implements Serializable {

    private static final long serialVersionUID = -6467624496190221365L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 父亲ID，预留
    */
    private Long parentId;

    /**
    * 市场名字
    */
    private String marketName;

    /**
    * 封面图片
    */
    private String imageUrl;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 排序
    */
    private Short sortNumber;

    /**
    * 地址
    */
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}