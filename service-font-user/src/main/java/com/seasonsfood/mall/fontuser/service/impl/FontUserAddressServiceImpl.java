package com.seasonsfood.mall.fontuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.fontuser.api.domain.FontUserAddress;
import com.seasonsfood.mall.fontuser.api.service.FontUserAddressService;
import com.seasonsfood.mall.fontuser.mapper.FontUserAddressMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;

import javax.annotation.Resource;

/**
 * @author Zero
 */
@Service(interfaceClass = FontUserAddressService.class)
public class FontUserAddressServiceImpl extends BaseServiceImpl<FontUserAddress> implements FontUserAddressService {

    @Resource
    FontUserAddressMapper fontUserAddressMapper;

    @Override
    public ResponseCode setDeliveryUserIdById(Long id, Long deliveryUserId) {
        int count = fontUserAddressMapper.updateByPrimaryKeySelective(new FontUserAddress(id,deliveryUserId));
        if(count <= 0){
            return ResponseCode.MODIFY_ERROR;
        }
        return ResponseCode.SUCCESS;
    }
}
