package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.ShopUserBankInfo;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * @Author zhaozhirong
 * @Date 2018/12/10 11:20
 * 银行卡信息接口
 */
public interface ShopUserBankInfoService extends BaseService<ShopUserBankInfo> {

    /**
     * 添加商户银行卡信息.
     * @param bankInfo
     * @return
     */
    ResponseCode addNewBankInfo(ShopUserBankInfo bankInfo);

    /**
     * 通过银行卡号查找银行卡信息
     * @param cardNumber
     * @return
     */
    ShopUserBankInfo selectBankInfoByCardNumber(String cardNumber);
    /**
     * 通过银行卡ID和用户id获取银行卡信息.
     *
     * @param bankInfoId
     * @param shopUserId
     * @return com.seasonsfood.mall.business.api.domain.ShopUserBankInfo
     */
    ShopUserBankInfo selectBankInfoByIdAndShopUserId(Long bankInfoId, Long shopUserId);
}