package com.seasonsfood.mall.business.api.result;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 寄存商品列表
 */
public class CheckList implements Serializable {
    private Long id;
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     *店铺名称
     */
    private String shopName;
    /**
     *分类名称
     */
    private String categoryName;
    /**
     *寄存数量
     */
    private BigDecimal quantityInStock;
    /**
     *剂量单位
     */
    private String unitName;
    /**
     *库存数量预警
     */
    private String countState;
    /**
     *保质期过半预警
     */
    private String expirationDateState;
    /**
     *已存时长
     */
    private Long saveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getCountState() {
        return countState;
    }

    public void setCountState(String countState) {
        this.countState = countState;
    }

    public String getExpirationDateState() {
        return expirationDateState;
    }

    public void setExpirationDateState(String expirationDateState) {
        this.expirationDateState = expirationDateState;
    }

    public Long getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Long saveTime) {
        this.saveTime = saveTime;
    }

    @Override
    public String toString() {
        return "CheckList{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", unitName=" + unitName +
                ", countState='" + countState + '\'' +
                ", expirationDateState='" + expirationDateState + '\'' +
                ", saveTime=" + saveTime +
                '}';
    }
}
