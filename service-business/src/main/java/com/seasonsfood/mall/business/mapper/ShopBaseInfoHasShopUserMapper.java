package com.seasonsfood.mall.business.mapper;

import com.seasonsfood.mall.business.api.domain.ShopBaseInfoHasShopUserKey;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author zhaozhirong
 * @Date 2018/12/10 11:43
 * 店铺用户表
 */
public interface ShopBaseInfoHasShopUserMapper extends Mapper<ShopBaseInfoHasShopUserKey> {
    /**
     * 通过店铺id查找商户id.
     *
     * @param shopId
     * @return java.lang.Long
     */
    Long findUserIdByShopId(Long shopId);

    /**
     * 通过商户id查找店铺id.
     *
     * @param userId
     * @return java.lang.Long
     */
    Long findShopIdByUserId(Long userId);

}