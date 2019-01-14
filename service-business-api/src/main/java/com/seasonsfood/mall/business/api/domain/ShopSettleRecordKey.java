package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
public class ShopSettleRecordKey implements Serializable {

    private static final long serialVersionUID = 535212778893453666L;
    /**
    * 商铺ID
    */
    @Id
    private Long shopBaseInfoId;

    /**
    * 结算时间（联合时间），同时根据记录的天数，关联到扣款记录 记录到年月日，
    */
    @Id
    private Date unityTime;

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }

    public Date getUnityTime() {
        return unityTime;
    }

    public void setUnityTime(Date unityTime) {
        this.unityTime = unityTime;
    }
}