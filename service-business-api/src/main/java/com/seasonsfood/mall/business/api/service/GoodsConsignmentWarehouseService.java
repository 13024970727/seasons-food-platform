package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.GoodsConsignmentWarehouse;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.model.ListResponse;

public interface GoodsConsignmentWarehouseService extends BaseService<GoodsConsignmentWarehouse> {

    ListResponse<GoodsConsignmentWarehouse> findList(Integer pageNum,Integer pageSize);
}
