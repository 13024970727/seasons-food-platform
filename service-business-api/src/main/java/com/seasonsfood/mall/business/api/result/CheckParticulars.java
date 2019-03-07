package com.seasonsfood.mall.business.api.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**jcw
 * 寄存商品详细信息
 */

public class CheckParticulars implements Serializable {
    private Long id;
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 经办人
     */
    private String responsiblePersonName;
    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 入库时间
     */
    private String warehouseEntryTime;
    /**
     * 寄存费用
     */
    private BigDecimal registerFee;
    /**
     * 寄存数量
     */
    private BigDecimal quantityInStock;
    /**
     * 剂量单位
     */
    private String unitName;
    /**
     * 库存数量预警
     */
    private String countState;
    /**
     * 保质期过半预警
     */
    private String expirationDateState;
    /**
     * 已存时长
     */
    private Long saveTime;

    public CheckParticulars() {
        super();
    }

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

    public String getResponsiblePersonName() {
        return responsiblePersonName;
    }

    public void setResponsiblePersonName(String responsiblePersonName) {
        this.responsiblePersonName = responsiblePersonName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseEntryTime() {
        return warehouseEntryTime;
    }

    public void setWarehouseEntryTime(String warehouseEntryTime) {
        this.warehouseEntryTime = warehouseEntryTime;
    }

    public BigDecimal getRegisterFee() {
        return registerFee;
    }

    public void setRegisterFee(BigDecimal registerFee) {
        this.registerFee = registerFee;
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
        return "CheckParticulars{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", responsiblePersonName='" + responsiblePersonName + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", warehouseEntryTime=" + warehouseEntryTime +
                ", registerFee=" + registerFee +
                ", quantityInStock=" + quantityInStock +
                ", unitName='" + unitName + '\'' +
                ", countState='" + countState + '\'' +
                ", expirationDateState='" + expirationDateState + '\'' +
                ", saveTime=" + saveTime +
                '}';
    }
}
