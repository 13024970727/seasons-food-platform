package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "shop_base_info_has_shop_user")
public class ShopBaseInfoHasShopUserKey implements Serializable {

    private static final long serialVersionUID = 5580152674000295899L;

    /**
    * 店铺id
    */
    @Id
    private Long shopBaseInfoId;

    @Id
    private Long shopUserId;

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }

    public Long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }
}