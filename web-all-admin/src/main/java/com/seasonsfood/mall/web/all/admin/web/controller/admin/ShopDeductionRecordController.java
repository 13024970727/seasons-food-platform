package com.seasonsfood.mall.web.all.admin.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.ShopDeductionRecord;
import com.seasonsfood.mall.business.api.service.ShopDeductionRecordService;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;

/**
 * 商户扣款信息管理
 *
 * @author Zero on 18-12-12
 */
public class ShopDeductionRecordController {

    @Reference(check = false)
    ShopDeductionRecordService shopDeductionRecordService;

    public JsonResponse addDeductionRecord(ShopDeductionRecord shopDeductionRecord){
        return ResponseUtils.setSuccess();
    }
}
