package com.seasonsfood.mall.servicemap.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.servicemap.api.domain.MapPenCoordinate;
import com.seasonsfood.mall.servicemap.api.service.MapPenCoordinateService;
import com.seasonsfood.mall.servicemap.mapper.MapPenCoordinateMapper;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component("mapPenCoordinateService")
@Service(interfaceClass = MapPenCoordinateService.class)
public class MapPenCoordinateServiceImpl extends BaseServiceImpl<MapPenCoordinate> implements MapPenCoordinateService {
    @Resource
    private MapPenCoordinateMapper mapPenCoordinateMapper;



    @Override
    public List<MapPenCoordinate> selectByAreaId(Integer areaId) {


        List<MapPenCoordinate> mapPenCoordinateList=  mapPenCoordinateMapper.selectByAreaId(areaId);


        return mapPenCoordinateList;
    }
}
