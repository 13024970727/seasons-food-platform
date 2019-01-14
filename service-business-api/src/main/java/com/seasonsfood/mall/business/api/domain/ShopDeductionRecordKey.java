package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author ron
 */
public class ShopDeductionRecordKey implements Serializable {

    private static final long serialVersionUID = -8563542996442103244L;

    /**
    * 商铺ID
    */
    @Id
    private Long shopBaseInfoId;

    /**
    * 记录时间(联合时间)，同时根据商户ID记录的时间关联到结算记录 年月日
    */
    @Id
    private String unityTime;

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }

    public String getUnityTime() {
        return unityTime;
    }

    public void setUnityTime(String unityTime) {
        this.unityTime = unityTime;
    }
}