package com.seasonsfood.mall.servicemap.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.servicemap.api.domain.MapVillage;
import com.seasonsfood.mall.util.model.ListResponse;

public interface MapVillageService extends BaseService <MapVillage>{

/*
通过小区名字搜索小区列表
 */
    ListResponse getVillageList(String villageName,Integer stateId ,Integer pageNum, Integer pageSize);

    ListResponse getVillageListByLngAndLat(Double lng,Double lat ,Integer pageNum);



}
