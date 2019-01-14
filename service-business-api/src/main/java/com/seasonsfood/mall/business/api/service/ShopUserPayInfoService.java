package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.ShopUserPayInfo;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * @Author zhaozhirong
 * @Date 2018/12/10 11:20
 * 银行卡信息接口
 */
public interface ShopUserPayInfoService extends BaseService<ShopUserPayInfo> {

    /**
     * 添加收款二维码信息
     * @param payInfo
     * @return
     */
    ResponseCode addNewPayInfo(ShopUserPayInfo payInfo);

    /**
     * 查询收款信息是否正确
     * @param receiptId
     * @param id
     * @return
     */
    ShopUserPayInfo selectPayInfoByIdAndShopUserId(Long receiptId, Short type,Long id);
}