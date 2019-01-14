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
@Table(name = "variety_category")
public class VarietyCategory implements Serializable {

    private static final long serialVersionUID = -5926024688652639034L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
    * 父亲ID，预留
    */
    private Long parentId;

    /**
    * 品类名字
    */
    private String varietyName;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 排序
    */
    private Short sortNumber;

    /**
    * 是否显示
    */
    private Byte isShow;

    /**
    * 是否精选分类
    */
    private Byte isChosen;

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

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
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

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public Byte getIsChosen() {
        return isChosen;
    }

    public void setIsChosen(Byte isChosen) {
        this.isChosen = isChosen;
    }
}