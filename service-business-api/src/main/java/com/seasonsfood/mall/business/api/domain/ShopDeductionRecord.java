package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "shop_deduction_record")
public class ShopDeductionRecord extends ShopDeductionRecordKey implements Serializable {
    private static final long serialVersionUID = -2207062165680966992L;
    /**
    * 商品ID
    */
    private Long goodsId;

    /**
    * 赔偿金额
    */
    private BigDecimal dutyMoney;

    /**
    * 赔偿描述
    */
    private String description;

    /**
    * 赔偿图片
    */
    private String extralPicture;

    /**
    * 创建时间
    */
    private Date createTime;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getDutyMoney() {
        return dutyMoney;
    }

    public void setDutyMoney(BigDecimal dutyMoney) {
        this.dutyMoney = dutyMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtralPicture() {
        return extralPicture;
    }

    public void setExtralPicture(String extralPicture) {
        this.extralPicture = extralPicture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}