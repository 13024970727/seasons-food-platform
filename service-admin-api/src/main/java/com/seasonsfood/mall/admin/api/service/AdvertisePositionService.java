package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.AdvertisePosition;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

/**
 * @author zq
 * 广告位置管理service
 */
public interface AdvertisePositionService extends BaseService<AdvertisePosition> {

    /**
     * 广告位置列表
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 广告位置列表
     */
    ListResponse getAdvertisePositionList(Integer pageNum,Integer pageSize);
}
