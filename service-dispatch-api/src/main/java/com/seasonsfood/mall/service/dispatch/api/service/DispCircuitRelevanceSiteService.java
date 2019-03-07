package com.seasonsfood.mall.service.dispatch.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;

import java.util.List;

public interface DispCircuitRelevanceSiteService extends BaseService<DispCircuitRelevanceSite> {
    /**jcw
     * 配送线路添加地点
     * @param dispCircuitRelevanceSite
     * @return
     */
    Integer addDispCircuitRelevanceSite(List<DispCircuitRelevanceSite> dispCircuitRelevanceSite);

}
