package com.seasonsfood.mall.map.mapper;

import com.seasonsfood.mall.map.api.domain.MapPenCoordinate;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MapPenCoordinateMapper extends Mapper<MapPenCoordinate> {
    //找到属于这个围栏顶点坐标
    List<MapPenCoordinate> selectByAreaId(Integer areaId);

}
