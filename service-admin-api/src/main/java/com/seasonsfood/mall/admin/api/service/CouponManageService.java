package com.seasonsfood.mall.admin.api.service;

import com.seasonsfood.mall.admin.api.domain.CouponManage;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

/**
 * @author zq
 * 优惠券service
 */
public interface CouponManageService extends BaseService<CouponManage> {

    /**
     * 优惠券列表
     * @param couponName 优惠券名称
     * @param couponType 优惠券类型
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 优惠券列表
     */
    ListResponse getCouponManageList(String couponName,Integer couponType,Integer pageNum,Integer pageSize);
}
