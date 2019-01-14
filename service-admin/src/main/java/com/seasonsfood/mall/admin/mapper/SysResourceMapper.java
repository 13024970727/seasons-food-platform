package com.seasonsfood.mall.admin.mapper;

import com.seasonsfood.mall.admin.api.domain.SysResource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ron
 */
public interface SysResourceMapper extends Mapper<SysResource> {

    /**
     * 查找跟目录
     * @param uid
     * @return
     */
    List<SysResource> findRootMenus(Long uid);

    /**
     * 通过用户id获取用户资源
     * @param userId
     * @return
     */
    List<SysResource> findMenusByUserId(Long userId);
}