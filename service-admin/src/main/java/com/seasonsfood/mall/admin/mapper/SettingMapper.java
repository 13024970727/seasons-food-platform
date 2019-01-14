package com.seasonsfood.mall.admin.mapper;


import com.seasonsfood.mall.admin.api.domain.Setting;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ron
 */
public interface SettingMapper extends Mapper<Setting> {

    /**
     * 通过分类编号查找所有的设置
     *
     * @param categoryId
     *         分类编号
     *
     * @return 设置列表
     */
    List<Setting> findByCategoryId(Integer categoryId);

}