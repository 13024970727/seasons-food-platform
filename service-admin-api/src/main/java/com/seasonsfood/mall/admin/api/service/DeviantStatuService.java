package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.DeviantStatu;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

/**
 * @author zq
 */
public interface DeviantStatuService extends BaseService<DeviantStatu> {

    /**
     * 异常列表
     * @param name 名称
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 异常列表
     */
    ListResponse<DeviantStatu> getDeviantStatuList(String name, Integer pageNum, Integer pageSize);
}
