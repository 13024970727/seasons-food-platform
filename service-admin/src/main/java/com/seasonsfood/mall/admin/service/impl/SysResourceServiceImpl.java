package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.admin.api.domain.SysResource;
import com.seasonsfood.mall.admin.api.service.SysResourceService;
import com.seasonsfood.mall.admin.mapper.SysResourceMapper;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ron
 */
@Component
@Service(interfaceClass = SysResourceService.class)
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource> implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourceMapper;


    @Override
    public List<SysResource> findRootMenus(Long uid) {
        return sysResourceMapper.findRootMenus(uid);
    }

    @Override
    public Map<String, String> getResourceMap() {
        Map<String,String> moduleMap = new HashMap<>();
        Example example = new Example(SysResource.class);
        example.or().andNotEqualTo("url",null).andNotEqualTo("url","");
        List<SysResource> sysResourceList = this.selectPageByExample(example,null,null);
        for (SysResource sysResource : sysResourceList){
            moduleMap.put(sysResource.getUrl(),sysResource.getResourceName());
        }
        return moduleMap;
    }

    @Override
    public Long savaAndReturnId(SysResource sysResource) {
        sysResourceMapper.insert(sysResource);
        return sysResource.getId();
    }

    @Override
    public List<SysResource> findMenusByUserId(Long userId) {
        return sysResourceMapper.findMenusByUserId(userId);
    }
}
