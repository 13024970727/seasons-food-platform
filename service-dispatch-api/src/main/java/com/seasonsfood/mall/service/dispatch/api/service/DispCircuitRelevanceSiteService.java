package com.seasonsfood.mall.service.dispatch.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;

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

}
