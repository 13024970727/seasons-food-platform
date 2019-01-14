package com.seasonsfood.mall.admin.api.service;


import com.seasonsfood.mall.admin.api.domain.SettingCategory;
import com.seasonsfood.mall.core.service.BaseService;

/**
 * @author ron
 */
public interface SettingCategoryService extends BaseService<SettingCategory> {

    /**
     * 保存并返回ID
     * @param settingCategory 设置分类信息
     * @return 保存结果
     */
    Integer savaAndReturnId(SettingCategory settingCategory);


}
