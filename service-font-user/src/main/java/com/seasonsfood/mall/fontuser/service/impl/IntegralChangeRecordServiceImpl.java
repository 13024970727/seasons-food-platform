package com.seasonsfood.mall.fontuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.fontuser.api.domain.IntegralChangeRecord;
import com.seasonsfood.mall.fontuser.api.service.IntegralChangeRecordService;

/**
 * @author Zero on 18-12-12
 */
@Service(interfaceClass = IntegralChangeRecordService.class)
public class IntegralChangeRecordServiceImpl extends BaseServiceImpl<IntegralChangeRecord> implements IntegralChangeRecordService {
}
