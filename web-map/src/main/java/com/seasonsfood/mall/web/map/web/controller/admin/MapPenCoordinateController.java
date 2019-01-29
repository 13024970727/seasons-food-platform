package com.seasonsfood.mall.web.map.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.map.api.domain.MapPenCoordinate;
import com.seasonsfood.mall.map.api.result.MapVertexCoorDinates;
import com.seasonsfood.mall.map.api.service.MapPenCoordinateService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("penCoordinate")
public class MapPenCoordinateController {

    @Reference(check = false)
    private MapPenCoordinateService mapPenCoordinateService;


    /*
    根据地图围栏id获取顶点坐标
     */
    @RequestMapping("info")
    public JsonResponse getMapPenCoorDinateInfo(Integer id){

        if(id == null){
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL,"参数不能为空",true);
        }
        //根据找到的地图id获取顶点坐标
        List<MapPenCoordinate> mapPenCoordinateList = mapPenCoordinateService.selectByAreaId(id);
        if (mapPenCoordinateList.size() == 0) {
            return ResponseUtils.setToJson(ResponseCode.DATA_ERROR);
        }
        List<MapVertexCoorDinates> mapVertexCoorDinatesList = new ArrayList<MapVertexCoorDinates>();
        for (int i = 0; i < mapPenCoordinateList.size(); i++) {
            MapVertexCoorDinates mapVertexCoorDinates = new MapVertexCoorDinates();
            mapVertexCoorDinates.setLng(mapPenCoordinateList.get(i).getLng());
            mapVertexCoorDinates.setLat(mapPenCoordinateList.get(i).getLat());
            mapVertexCoorDinatesList.add(mapVertexCoorDinates);
        }
        return ResponseUtils.setSuccess(mapVertexCoorDinatesList);
    }

}
