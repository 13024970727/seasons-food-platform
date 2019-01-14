package com.seasonsfood.mall.delivery.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.delivery.api.domain.DeliveryUser;
import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * @author Zero on 18-12-12
 */
public interface DeliveryUserService extends BaseService<DeliveryUser> {

    /**
     * 创建用户
     *
     * @param deliveryUser
     * @return
     */
    ResponseCode addUser(DeliveryUser deliveryUser);
}
