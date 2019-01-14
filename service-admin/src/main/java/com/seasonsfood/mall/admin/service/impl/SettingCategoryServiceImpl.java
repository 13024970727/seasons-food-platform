package com.seasonsfood.mall.admin.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.admin.api.domain.SettingCategory;
import com.seasonsfood.mall.admin.api.service.SettingCategoryService;
import com.seasonsfood.mall.admin.mapper.SettingCategoryMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author ron
 */
@Component("settingCategoryService")
@Service(interfaceClass = SettingCategoryService.class)
public class SettingCategoryServiceImpl extends BaseServiceImpl<SettingCategory> implements SettingCategoryService {

    @Resource
    private SettingCategoryMapper settingCategoryMapper;

    /**
     *
     * @param settingCategory 设置分类信息
     * @return
     */
    @Override
    public Integer savaAndReturnId(SettingCategory settingCategory) {
        settingCategoryMapper.insert(settingCategory);
        return settingCategory.getId();
    }

}
