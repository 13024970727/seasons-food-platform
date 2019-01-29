package com.seasonsfood.mall.map.mapper;

import com.seasonsfood.mall.map.api.domain.MapVillage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MapVillageMapper extends Mapper<MapVillage> {
    //查找在范围内的小区
    List<MapVillage> selectVillageListByLngAndLat(@Param("lng") double lng,@Param("lat") double lat,@Param("pageLimit") int pageLimit,@Param("pageSize") int pageSize);


}
