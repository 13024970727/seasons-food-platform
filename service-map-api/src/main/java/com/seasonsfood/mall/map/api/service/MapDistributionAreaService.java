package com.seasonsfood.mall.map.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.map.api.domain.MapDistributionArea;
import com.seasonsfood.mall.map.api.domain.MapPenCoordinate;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

public interface MapDistributionAreaService extends BaseService<MapDistributionArea> {
    //找到当前正在启用的围栏
    MapDistributionArea selectByState();

    //获取围栏列表
    ListResponse<MapDistributionArea> getMapPenList(Integer pageNum, Integer pageSize);

    //启用围栏
    Boolean startUsingMapPen(Integer id);

    //禁用围栏
    Boolean forbiddenMapPen(Integer id);

    //创建围栏
    Boolean saveMapPen(MapDistributionArea mapDistributionArea, List<MapPenCoordinate> MapPenCoordinateList);

    //修改
    Boolean updateMapPen(MapDistributionArea mapDistributionArea, List<MapPenCoordinate> MapPenCoordinateList);
}
