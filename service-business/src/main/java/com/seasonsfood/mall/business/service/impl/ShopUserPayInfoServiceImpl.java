package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.ShopUserPayInfo;
import com.seasonsfood.mall.business.api.service.ShopUserPayInfoService;
import com.seasonsfood.mall.business.mapper.ShopUserPayInfoMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.constant.ResponseCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author zhaozhirong
 * @Date 2018/12/8 9:28
 */
@Component
@Service(interfaceClass = ShopUserPayInfoService.class)
public class ShopUserPayInfoServiceImpl extends BaseServiceImpl<ShopUserPayInfo> implements ShopUserPayInfoService {

    @Resource
    ShopUserPayInfoMapper shopUserPayInfoMapper;

    @Override
    public ResponseCode addNewPayInfo(ShopUserPayInfo payInfo) {
        payInfo.setId(null);
        payInfo.setCreateTime(new Date());
        Integer count = mapper.insertSelective(payInfo);
        if (count == 1) {
            return ResponseCode.SUCCESS;
        }
        return ResponseCode.ADD_ERROR;
    }

    @Override
    public ShopUserPayInfo selectPayInfoByIdAndShopUserId(Long id,Short type, Long shopUserId) {
        ShopUserPayInfo shopUserPayInfo=new ShopUserPayInfo();
        shopUserPayInfo.setId(id);
        shopUserPayInfo.setPayType(type);
        shopUserPayInfo.setShopUserId(shopUserId);
        return mapper.selectOne(shopUserPayInfo);
    }
}