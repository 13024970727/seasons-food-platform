package com.seasonsfood.mall.service.dispatch.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;
import com.seasonsfood.mall.service.dispatch.api.result.RegisterUserNumAndSiteNum;
import java.util.List;

public interface DispCircuitRelevanceSiteService extends BaseService<DispCircuitRelevanceSite> {
    /**
     * @author jiangchengwei
     * @date: 2019/3/11-10:50
     * @methodExplain： 配送线路添加地点
     * @param dispCircuitRelevanceSite
     * @return：
     */
    Integer addDispCircuitRelevanceSite(List<DispCircuitRelevanceSite> dispCircuitRelevanceSite);
    /**
     * @author jiangchengwei
     * @date: 2019/3/14-10:28
     * @methodExplain： 统计这条线下的配送地点数量
     * @param circuitId 线路ID
     * @return： java.lang.Integer
     */
    Integer countCircuitDispSite (Long circuitId);

    /**
     * @author jiangchengwei
     * @date: 2019/3/14-10:28
     * @methodExplain： 统计这条线下的注册用户数量
     * @param circuitId 线路ID
     * @return： java.lang.Integer
     */
    Integer countCircuitRegisterUserNum (Long circuitId);
    /**
     * @author jiangchengwei
     * @date: 2019/3/14-11:43
     * @methodExplain： 统计启用配送地点数量和注册用户数量
     * @param
     * @return： RegisterUserNumAndSiteNum
     */
    RegisterUserNumAndSiteNum countRegisterUserNumAndSiteNum ();
}
