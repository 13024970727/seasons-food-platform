package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.Announcement;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

/**
 * @author zq
 */
public interface AnnouncementService extends BaseService<Announcement> {

    /**
     * 公告列表
     * @param announceType 公告类型
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 公告列表
     */
    ListResponse getAnnouncementList(String announceType,Integer pageNum, Integer pageSize);
}
