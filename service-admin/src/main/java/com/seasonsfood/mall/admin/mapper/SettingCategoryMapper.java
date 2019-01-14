package com.seasonsfood.mall.admin.mapper;


import com.seasonsfood.mall.admin.api.domain.SettingCategory;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author ron
 */
public interface SettingCategoryMapper extends Mapper<SettingCategory> {

    /**
     * 得到code下的分类
     *
     * @param code
     *         分类Code
     *
     * @return 设置分类
     */
    SettingCategory findByCode(String code);

}