package com.seasonsfood.mall.fontuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.fontuser.api.domain.MoneyChangeRecord;
import com.seasonsfood.mall.fontuser.api.service.MoneyChangeRecordService;

/**
 * @author Zero on 18-12-12
 */
@Service(interfaceClass = MoneyChangeRecordService.class)
public class MoneyChangeRecordServiceImpl extends BaseServiceImpl<MoneyChangeRecord> implements MoneyChangeRecordService {
}
