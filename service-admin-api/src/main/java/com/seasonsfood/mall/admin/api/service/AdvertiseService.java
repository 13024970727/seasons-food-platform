package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.Advertise;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

/**
 * @author zq
 */
public interface AdvertiseService extends BaseService<Advertise> {

    /**
     * 获得广告列表
     * @param name 广告名称
     * @param advertisePositionId id
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 广告列表
     */
    ListResponse getAdvertiseList(String name, Long advertisePositionId, Integer pageNum, Integer pageSize);
}
