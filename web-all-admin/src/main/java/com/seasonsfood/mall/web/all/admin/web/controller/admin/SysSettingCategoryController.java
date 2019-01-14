package com.seasonsfood.mall.web.all.admin.web.controller.admin;



import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.Setting;
import com.seasonsfood.mall.admin.api.domain.SettingCategory;
import com.seasonsfood.mall.admin.api.service.SettingCategoryService;
import com.seasonsfood.mall.admin.api.service.SettingService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.TreeModel;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ron
 */
@RestController
@RequestMapping("settingCategory")
public class SysSettingCategoryController {

    @Reference(check = false)
    private SettingCategoryService settingCategoryService;

    @Reference(check = false)
    private SettingService settingService;

    /**
     * 获取类别树
     * @return  类别树
     */
    @GetMapping(value = "tree")
    public Object getCategoryTree(){
        List<SettingCategory> categoryList = settingCategoryService.selectPage(null,null);
        List<TreeModel> treeModelList = new ArrayList<>();
        for (SettingCategory articleCategory : categoryList){
            TreeModel treeModel = new TreeModel(articleCategory.getId().longValue(),articleCategory.getParentId().longValue(),articleCategory.getCategoryName());
            treeModelList.add(treeModel);
        }

        return ResponseUtils.setSuccess(treeModelList);
    }


    /**
     * 获取类别
     * @param id 类别id
     * @return 类别信息
     */
    @GetMapping(value = "{id}")
    public Object getCategoryById(@PathVariable Integer id){
        return settingCategoryService.selectByPrimary(new SettingCategory(id));
    }

    /**
     * 添加
     * @param settingCategory 类别实体
     * @return 作用的条数
     */
    @PostMapping
    public Object addArticleCategory(SettingCategory settingCategory){
        SettingCategory parentCategory = settingCategoryService.selectByPrimary(new SettingCategory(settingCategory.getParentId()));
        settingCategory.setParentIds(parentCategory.getParentIds()+parentCategory.getId()+"/");
        Integer id = settingCategoryService.savaAndReturnId(settingCategory);
        Map<String,Integer> result = new HashMap<>();
        result.put("id",id);
        return ResponseUtils.setSuccess(result);
    }

    /**
     * 修改
     * @param settingCategory 类别实体
     * @return 作用的条数
     */
    @PostMapping(value = "/update")
    public Object updateSettingCategory(SettingCategory settingCategory){
         settingCategoryService.updateSelective(settingCategory);
         return ResponseUtils.setSuccess(settingCategory);
    }

    /**
     * 删除
     * @param id 类别ID
     * @return 作用的条数
     */
    @DeleteMapping(value = "{id}")
    public Object deleteArticleCategory(@PathVariable Integer id){
        Setting settingForFind = new Setting();
        settingForFind.setCategoryId(id);
        List<Setting> articleList = settingService.selectByEntityWithSimpleResult(settingForFind,null,null);
        Boolean isCanBeDelete = articleList.isEmpty();
        if (isCanBeDelete){
             settingCategoryService.delete(new SettingCategory(id));
             return ResponseUtils.setSuccess();
        }
        return ResponseUtils.setToJson(ResponseCode.OTHER_ERROR);
    }
}
