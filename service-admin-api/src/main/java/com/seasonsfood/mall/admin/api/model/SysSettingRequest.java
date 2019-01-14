package com.seasonsfood.mall.admin.api.model;


import com.seasonsfood.mall.util.model.PageRequest;

/**
 * @author ron
 */
public class SysSettingRequest extends PageRequest {

    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
