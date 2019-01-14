package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.Setting;
import com.seasonsfood.mall.core.service.BaseService;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author ron
 */
public interface SettingService extends BaseService<Setting> {

    /**
     * 根据编码获取设置项.如果不存在返回默认设置
     * @param code 编码
     * @return  setting 设置项
     */
    Setting getSpecialSettingByCode(String code, String defaultValue);


}
