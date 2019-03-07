package com.seasonsfood.mall.business.api.model;

import java.io.Serializable;

/**
 * jcw
 */
public class CountGoodsTagInfo implements Serializable {
    private  Long id;
    /**
     * 标签名称
     */
    private  String tagName;
    /**
     * 标签状态
     */
    private  Integer stateId;
    /**
     * 商品数量
     */
    private Integer countGoodsNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCountGoodsNumber() {
        return countGoodsNumber;
    }

    public void setCountGoodsNumber(Integer countGoodsNumber) {
        this.countGoodsNumber = countGoodsNumber;
    }

    @Override
    public String toString() {
        return "CountGoodsTagInfo{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", stateId=" + stateId +
                ", countGoodsNumber=" + countGoodsNumber +
                '}';
    }
}
