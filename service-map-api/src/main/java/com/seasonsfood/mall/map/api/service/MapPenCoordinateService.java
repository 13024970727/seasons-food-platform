package com.seasonsfood.mall.map.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.map.api.domain.MapPenCoordinate;



import java.util.List;

public interface MapPenCoordinateService extends BaseService<MapPenCoordinate> {

    //
   List<MapPenCoordinate> selectByAreaId(Integer areaId);
}
