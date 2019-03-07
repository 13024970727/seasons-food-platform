package com.seasonsfood.mall.business.api.model;

/**
 * jcw
 * 商品的所属分类以及所属店铺名称
 */
public class GoodsInfo {
    private String goodsName;
    private String categoryName;
    private String shopName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "goodsName='" + goodsName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}
