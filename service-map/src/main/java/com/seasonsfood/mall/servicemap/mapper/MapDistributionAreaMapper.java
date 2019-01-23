package com.seasonsfood.mall.servicemap.mapper;

import com.seasonsfood.mall.servicemap.api.domain.MapDistributionArea;
import tk.mybatis.mapper.common.Mapper;

public interface MapDistributionAreaMapper extends Mapper<MapDistributionArea> {

    //找到正在启用的地图围栏
    MapDistributionArea selectByState();

    //启用围栏
    void startUsing(Integer id);

    //禁用其他围栏
    void forbiddenAll();

    //禁用当前围栏
    void forbiddenNowaday(Integer id);


}
