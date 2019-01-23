package com.seasonsfood.mall.servicemap.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.servicemap.api.domain.MapVillage;
import com.seasonsfood.mall.util.model.ListResponse;

public interface MapVillageService extends BaseService <MapVillage>{

/*
ͨ��С����������С���б�
 */
    ListResponse getVillageList(String villageName,Integer stateId ,Integer pageNum, Integer pageSize);

    ListResponse getVillageListByLngAndLat(Double lng,Double lat ,Integer pageNum);



}
