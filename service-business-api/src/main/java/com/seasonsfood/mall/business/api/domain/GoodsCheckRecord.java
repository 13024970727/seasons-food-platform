package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
//商品寄存表
@Table(name = "goods_check_record")
public class GoodsCheckRecord implements Serializable {
    /**
     * 商品寄存Id
     */
    @Id
    private Long id;
    /**
     *商品Id
     */
    private Long goodsId;
    /**
     *入库经办人Id
     */
    private Long responsiblePersonId;
    /**
     *入库时间
     */
    private Date warehouseEntryTime;
    /**
     *寄存仓库Id
     */
    private Integer warehouseId;
    /**
     *寄存费用
     */
    private BigDecimal registerFee;
    /**
     *保质期
     */
    private Long expirationDate;
    /**
     *寄存数量
     */
    private BigDecimal quantityInStock;
    /**
     *剂量单位
     */
    private Integer unitId;
    /**
     *记录状态（是否展示 1展示 2不展示）
     */
    private Integer stateId;
    /**
     *库存状态（是否展示 1充足 2库存不足）
     */
    private Integer saveStateId;
    /**
     * 保质期预警
     */
    private Long deadlineWarning;
    /**
     * 库存数量预警
     */
    private BigDecimal quantityWarning;
    /**
     * 生产日期
     */

    private Date dateInProduced;
    public GoodsCheckRecord() {
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

    public Long getResponsiblePersonId() {
        return responsiblePersonId;
    }

    public void setResponsiblePersonId(Long responsiblePersonId) {
        this.responsiblePersonId = responsiblePersonId;
    }

    public Date getWarehouseEntryTime() {
        return warehouseEntryTime;
    }

    public void setWarehouseEntryTime(Date warehouseEntryTime) {
        this.warehouseEntryTime = warehouseEntryTime;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getRegisterFee() {
        return registerFee;
    }

    public void setRegisterFee(BigDecimal registerFee) {
        this.registerFee = registerFee;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
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

    public Long getDeadlineWarning() {
        return deadlineWarning;
    }

    public void setDeadlineWarning(Long deadlineWarning) {
        this.deadlineWarning = deadlineWarning;
    }

    public BigDecimal getQuantityWarning() {
        return quantityWarning;
    }

    public void setQuantityWarning(BigDecimal quantityWarning) {
        this.quantityWarning = quantityWarning;
    }

    public Date getDateInProduced() {
        return dateInProduced;
    }

    public void setDateInProduced(Date dateInProduced) {
        this.dateInProduced = dateInProduced;
    }

    @Override
    public String toString() {
        return "GoodsCheckRecord{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", responsiblePersonId=" + responsiblePersonId +
                ", warehouseEntryTime=" + warehouseEntryTime +
                ", warehouseId=" + warehouseId +
                ", registerFee=" + registerFee +
                ", expirationDate=" + expirationDate +
                ", quantityInStock=" + quantityInStock +
                ", unitId=" + unitId +
                ", stateId=" + stateId +
                ", saveStateId=" + saveStateId +
                ", deadlineWarning=" + deadlineWarning +
                ", quantityWarning=" + quantityWarning +
                ", dateInProduced=" + dateInProduced +
                '}';
    }
}
