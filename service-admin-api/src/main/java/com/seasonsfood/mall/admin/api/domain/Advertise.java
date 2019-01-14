package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "advertise")
public class Advertise implements Serializable {

    private static final long serialVersionUID = 7483287509710375101L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
    * 广告名字

    */
    private String adName;

    /**
    * 内容
    */
    private String content;

    /**
    * 图片地址
    */
    private String pictureUrl;

    /**
    * 关联地址
    */
    private String referUrl;

    /**
    * 备注
    */
    private String remark;

    /**
    * 创建时间
    */
    private Date createTime;

    private Long advertiseCategoryId;

    private Long advertisePositionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getReferUrl() {
        return referUrl;
    }

    public void setReferUrl(String referUrl) {
        this.referUrl = referUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAdvertiseCategoryId() {
        return advertiseCategoryId;
    }

    public void setAdvertiseCategoryId(Long advertiseCategoryId) {
        this.advertiseCategoryId = advertiseCategoryId;
    }

    public Long getAdvertisePositionId() {
        return advertisePositionId;
    }

    public void setAdvertisePositionId(Long advertisePositionId) {
        this.advertisePositionId = advertisePositionId;
    }
}