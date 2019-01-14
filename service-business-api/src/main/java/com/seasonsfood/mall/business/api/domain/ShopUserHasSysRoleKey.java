package com.seasonsfood.mall.business.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "shop_user_has_sys_role")
public class ShopUserHasSysRoleKey implements Serializable {

    private static final long serialVersionUID = -7013044514806778505L;
    /**
    * 商户id
    */
    @Id
    private Long shopUserId;

    /**
    * 角色id
    */
    @Id
    private Long sysRoleId;

    public Long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}