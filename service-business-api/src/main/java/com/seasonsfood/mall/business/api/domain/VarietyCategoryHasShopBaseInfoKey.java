package com.seasonsfood.mall.business.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "variety_category_has_shop_base_info")
public class VarietyCategoryHasShopBaseInfoKey implements Serializable {

    private static final long serialVersionUID = -1302167633970582374L;

    /**
    * 品种分类ID
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long varietyCategoryId;

    /**
    * 商铺ID
    */
    private Long shopBaseInfoId;

    public Long getVarietyCategoryId() {
        return varietyCategoryId;
    }

    public void setVarietyCategoryId(Long varietyCategoryId) {
        this.varietyCategoryId = varietyCategoryId;
    }

    public Long getShopBaseInfoId() {
        return shopBaseInfoId;
    }

    public void setShopBaseInfoId(Long shopBaseInfoId) {
        this.shopBaseInfoId = shopBaseInfoId;
    }
}