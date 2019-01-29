package com.seasonsfood.mall.map.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.map.api.domain.MapVillage;
import com.seasonsfood.mall.util.model.ListResponse;

public interface MapVillageService extends BaseService <MapVillage>{

/*
根据小区名字和状态
 */
    ListResponse getVillageList(String villageName,Integer stateId ,Integer pageNum, Integer pageSize);
/*
根据经纬度获取附近小区
 */
    ListResponse getVillageListByLngAndLat(Double lng,Double lat ,Integer pageNum,Integer pageSize);

    /**
     * 查找小区是否存在
     * @param villageName
     * @return
     */
    Boolean selectVillage(String villageName);

    /**
     * 修改地点状态
     * @return
     */
    Boolean updateVillageState(MapVillage mapVillage);

}
