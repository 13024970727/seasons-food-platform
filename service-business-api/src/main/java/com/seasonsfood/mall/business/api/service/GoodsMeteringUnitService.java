package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.GoodsMeteringUnit;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

public interface GoodsMeteringUnitService extends BaseService<GoodsMeteringUnit> {

    ListResponse<GoodsMeteringUnit> getMeteringUnitList(String unitName, Byte stateId, Integer pageNum, Integer pageSize);
}
