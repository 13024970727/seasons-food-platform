package com.seasonsfood.mall.fontuser.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.fontuser.api.domain.FontUserAddress;
import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * @author Zero
 */
public interface FontUserAddressService extends BaseService<FontUserAddress> {

    /**
     * 通过收货地址id设置配送员id
     *
     * @param id
     * @param deliveryUserId
     * @return
     */
    ResponseCode setDeliveryUserIdById(Long id, Long deliveryUserId);
}
