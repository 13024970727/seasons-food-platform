package com.seasonsfood.mall.servicemap.mapper;

import com.seasonsfood.mall.servicemap.api.domain.MapVillage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MapVillageMapper extends Mapper<MapVillage> {

 List<MapVillage>  selectVillageListByLngAndLat(@Param("minlng") double minlng ,@Param("maxlng") double maxlng, @Param("minlat")double minlat,@Param("maxlat") double maxlat);


}
