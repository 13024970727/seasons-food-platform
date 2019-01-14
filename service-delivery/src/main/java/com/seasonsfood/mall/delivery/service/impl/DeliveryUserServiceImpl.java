package com.seasonsfood.mall.delivery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.delivery.api.domain.DeliveryUser;
import com.seasonsfood.mall.delivery.api.service.DeliveryUserService;
import com.seasonsfood.mall.delivery.mapper.DeliveryUserMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.util.PasswordHelper;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Zero on 18-12-12
 */
@Service(interfaceClass = DeliveryUserService.class)
public class DeliveryUserServiceImpl extends BaseServiceImpl<DeliveryUser> implements DeliveryUserService {

    @Resource
    DeliveryUserMapper deliveryUserMapper;

    @Resource
    PasswordHelper passwordHelper;

    /**
     *
     * @param deliveryUser
     * @return
     */
    @Override
    public ResponseCode addUser(DeliveryUser deliveryUser) {

        // 密码加密
        this.encryptPassword(deliveryUser,deliveryUser.getPassword());

        int count = deliveryUserMapper.insertSelective(deliveryUser);
        if(count <= 0){
            return ResponseCode.ADD_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    /**
     * 密码加密，并设置到用户实体中
     *
     * @param user 用户实体
     * @param password 密码
     */
    private void encryptPassword(DeliveryUser user,String password){
        Map<String,String> passwordMap = passwordHelper.encryptPassword(password,user.getUsername());
        user.setSalt(passwordMap.get("salt"));
        user.setPassword(passwordMap.get("password"));
    }
}
