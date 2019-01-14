package com.seasonsfood.mall.web.all.admin.web.controller.admin;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.Setting;
import com.seasonsfood.mall.admin.api.domain.SettingCategory;
import com.seasonsfood.mall.admin.api.model.SysSettingRequest;
import com.seasonsfood.mall.admin.api.service.SettingCategoryService;
import com.seasonsfood.mall.admin.api.service.SettingService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ron
 * @date 17-4-23
 */
@RequestMapping("setting")
@RestController
public class SysSettingController {

    @Reference(check = false)
    SettingService settingService;

    @Reference(check = false)
    SettingCategoryService settingCategoryService;

    /**
     * 获取设置列表
     * @param request 请求域
     * @return 设置列表
     */
    @PostMapping(value = "list")
    public Object getListByCid(SysSettingRequest request){
        if (request.getPage() == null){
            request.setPage(1);
        }
        if (request.getPageSize() == null){
            request.setPageSize(10);
        }
        Setting setting = new Setting();
        setting.setCategoryId(request.getCategoryId());
        setting.setIsShow(true);

        ListResponse<Setting> settingListResponse = settingService.selectByEntityInListResponse(setting,request.getPage(),request.getPageSize());

        return ResponseUtils.setDataAndResponse(settingListResponse);
    }

    /**
     * 根据id获取设置
     * @param id 设置id
     * @return 设置信息
     */
    @GetMapping(value = "info")
    public Object getSettingInfo(Long id){
        if (id == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"");
        }
        Setting setting = settingService.selectByPrimary(new Setting(id));
        if (setting == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.ERROR, "设置参数错误", true);
        }
        return ResponseUtils.setSuccess(setting);
    }


    /**
     * 根据编码获得设置
     * @param code 设置编码
     * @return 设置信息
     */
    @GetMapping(value = "all/{code}")
    public Object getListByCode(@PathVariable String code){

        SettingCategory settingCategoryForFind = new SettingCategory();
        settingCategoryForFind.setCategoryCode(code);
        SettingCategory settingCategory = settingCategoryService.selectOne(settingCategoryForFind);
        if (settingCategory != null) {
            Setting settingForFind = new Setting();
            settingForFind.setCategoryId(settingCategory.getId());
            return settingService.selectByEntityWithSimpleResult(settingForFind, null, null);
        }else {
            return null;
        }
    }


    /**
     * 添加设置
     * @param setting 添加的设置信息
     * @return 设置成功
     */
    @PostMapping(value = "add")
    public Object addSetting(Setting setting){
        setting.setIsShow(true);
        settingService.saveSelective(setting);
        return ResponseUtils.setSuccess();
    }

    /**
     * 修改设置
     * @param sysSetting 修改的设置信息
     * @return 修改成功
     */
    @PostMapping(value = "update")
    public Object updateSetting(Setting sysSetting){
        if (sysSetting.getId() == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"");
        }
        settingService.updateSelective(sysSetting);
        return ResponseUtils.setSuccess();
    }

    /**
     * 删除设置
     * @param id 设置的id
     * @return 删除成功
     */
    @PostMapping(value = "/delete")
    public Object deleteSetting(Long id){
        settingService.delete(new Setting(id));
        return ResponseUtils.setSuccess();
    }


}
