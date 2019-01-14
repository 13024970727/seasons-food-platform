package com.seasonsfood.mall.admin.api.service;


import com.seasonsfood.mall.admin.api.domain.SysResource;
import com.seasonsfood.mall.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @author ron
 */
public interface SysResourceService extends BaseService<SysResource> {
    /**
     * 根据UID查找资源根目录
     * @param uid id
     * @return 资源根目录集合
     */
    List<SysResource> findRootMenus(Long uid);

    /**
     * 获取资源集合
     * @return 资源集合
     */
    Map<String,String> getResourceMap();

    /**
     * 保存数据并且返回ID
     * @return id
     */
    Long savaAndReturnId(SysResource sysResource);

    /**
     * 根据用户获取资源列表
     * @param id 用户id
     * @return 资源列表
     */
    List<SysResource> findMenusByUserId(Long id);
}
