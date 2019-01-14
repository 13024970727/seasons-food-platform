package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.ShopUserBankInfo;
import com.seasonsfood.mall.business.api.service.ShopUserBankInfoService;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author zhaozhirong
 * @Date 2018/12/8 9:28
 */
@Component
@Service(interfaceClass = ShopUserBankInfoService.class)
public class ShopUserBankInfoServiceImpl extends BaseServiceImpl<ShopUserBankInfo> implements ShopUserBankInfoService {


    @Override
    public ShopUserBankInfo selectBankInfoByIdAndShopUserId(Long id,Long shopUserId) {
        ShopUserBankInfo shopUserBankInfo=new ShopUserBankInfo();
        shopUserBankInfo.setId(id);
        shopUserBankInfo.setShopUserId(shopUserId);
        return mapper.selectOne(shopUserBankInfo);
    }

    @Override
    public ResponseCode addNewBankInfo(ShopUserBankInfo bankInfo) {
        bankInfo.setId(null);
        bankInfo.setCreateTime(new Date());
        Integer count = mapper.insertSelective(bankInfo);
        if (count == 1) {
            return ResponseCode.SUCCESS;
        }
        return ResponseCode.ADD_ERROR;
    }

    @Override
    public ShopUserBankInfo selectBankInfoByCardNumber(String cardNumber) {
        ShopUserBankInfo shopUserBankInfo = new ShopUserBankInfo();
        shopUserBankInfo.setCardNumber(cardNumber);
        return mapper.selectOne(shopUserBankInfo);
    }
}