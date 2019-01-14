package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.admin.api.domain.Setting;
import com.seasonsfood.mall.admin.api.service.SettingService;
import com.seasonsfood.mall.admin.mapper.SettingMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author ron
 */
@Component("settingService")
@Service(interfaceClass = SettingService.class)
public class SettingServiceImpl extends BaseServiceImpl<Setting> implements SettingService {

    @Resource
    private SettingMapper settingMapper;

    /**
     *
     * @param code 编码
     * @param defaultValue 默认值
     * @return
     */
    @Override
    public Setting getSpecialSettingByCode(String code,String defaultValue) {
        Setting settingForFind = new Setting();
        settingForFind.setCode(code);
        Setting settingInDb = this.selectOne(settingForFind);
        if (settingInDb == null){
            Setting defaultSetting = new Setting(code,defaultValue);
            settingMapper.insertSelective(defaultSetting);
            return defaultSetting;
        }

        return settingInDb;
    }

}
