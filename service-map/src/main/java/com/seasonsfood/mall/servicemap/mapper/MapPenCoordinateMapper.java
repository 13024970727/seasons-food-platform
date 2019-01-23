package com.seasonsfood.mall.servicemap.mapper;

import com.seasonsfood.mall.servicemap.api.domain.MapPenCoordinate;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MapPenCoordinateMapper extends Mapper<MapPenCoordinate> {

List<MapPenCoordinate> selectByAreaId(Integer areaId);

}
