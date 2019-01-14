package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.ShopDeductionRecord;
import com.seasonsfood.mall.business.api.service.ShopDeductionRecordService;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;

/**
 * @author Zero on 18-12-12
 */
@Service(interfaceClass = ShopDeductionRecordService.class)
public class ShopDeductionRecordServiceImpl extends BaseServiceImpl<ShopDeductionRecord> implements ShopDeductionRecordService {
}
