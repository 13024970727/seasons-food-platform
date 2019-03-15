package com.seasonsfood.mall.business.api.model;
import java.io.Serializable;

/**
 * @author jiangchengwei
 * @date 2019-03-12-16:{04}
 */
public class SelectGoodScheckRecordParam implements Serializable {
    private String goodsName;//商品名称
    private String shopName;//商店名称
    private String goodsCategoryName;//分类名称
    private Integer stateId;//（是否展示 1展示 2不展示）
    private Integer saveStateId;//库存状态（是否展示 1充足 2库存不足）
    private String startTime;//起始时间
    private String endTime;//结束时间
    private Integer pageNum;//
    private Integer pageSize;//
    public SelectGoodScheckRecordParam(){
        super();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsCategoryName() {
        return goodsCategoryName;
    }

    public void setGoodsCategoryName(String goodsCategoryName) {
        this.goodsCategoryName = goodsCategoryName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getSaveStateId() {
        return saveStateId;
    }

    public void setSaveStateId(Integer saveStateId) {
        this.saveStateId = saveStateId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SelectGoodScheckRecordParam{" +
                "goodsName='" + goodsName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", goodsCategoryName='" + goodsCategoryName + '\'' +
                ", stateId=" + stateId +
                ", saveStateId=" + saveStateId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
