package com.seasonsfood.mall.web.map.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.servicemap.api.domain.MapDistributionArea;
import com.seasonsfood.mall.servicemap.api.domain.MapPenCoordinate;
import com.seasonsfood.mall.servicemap.api.result.MapVertexCoorDinates;
import com.seasonsfood.mall.servicemap.api.service.MapDistributionAreaService;
import com.seasonsfood.mall.servicemap.api.service.MapPenCoordinateService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("mapPen")
public class MapDistributionAreaController {

    @Reference(check = false)
    private MapDistributionAreaService mapDistributionAreaService;

    @Reference(check = false)
    private MapPenCoordinateService mapPenCoordinateService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
       获取正在使用的地图围栏
     */
    @PostMapping("getVertexCoordinates")
    public JsonResponse getVertexCoordinates() {
        //找到当前正在使用的地图
        MapDistributionArea mapDistributionArea = mapDistributionAreaService.selectByState();
        if (null == mapDistributionArea) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "当前未启用地图", true);
        }
        //根据找到的地图id获取顶点坐标
        List<MapPenCoordinate> mapPenCoordinateList = mapPenCoordinateService.selectByAreaId(mapDistributionArea.getId());
        if (mapPenCoordinateList.size() == 0) {
            return ResponseUtils.setToJson(ResponseCode.DATA_ERROR);
        }
        List<MapVertexCoorDinates> mapVertexCoorDinatesList = new ArrayList<>();
        for (int i = 0; i < mapPenCoordinateList.size(); i++) {
            MapVertexCoorDinates mapVertexCoorDinates = new MapVertexCoorDinates();
            mapVertexCoorDinates.setLng(mapPenCoordinateList.get(i).getLng());
            mapVertexCoorDinates.setLat(mapPenCoordinateList.get(i).getLat());
            mapVertexCoorDinatesList.add(mapVertexCoorDinates);
        }
        return ResponseUtils.setSuccess(mapVertexCoorDinatesList);
    }

    /*
    获取地图围栏列表
     */
    @PostMapping("list")
    public JsonResponse getMapPenList(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(mapDistributionAreaService.getMapPenList(pageNum, pageSize));
    }

    /*
    启用某个地图围栏
    只能启用一个
     */
    @PostMapping("startUsing")
    public JsonResponse startUsing(Integer id) {
        try {

            Boolean isSuccess = mapDistributionAreaService.startUsingMapPen(id);
            if (isSuccess) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "启用异常", true);
            }

        } catch (Exception e) {
            logger.error("startUsingMap:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "启用异常", true);
        }

    }

    /*
       禁用围栏
        */
    @PostMapping("forbidden")
    public JsonResponse forbidden(Integer id) {
        try {
            Boolean isSuccess = mapDistributionAreaService.forbiddenMapPen(id);
            if (isSuccess) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "禁用异常", true);
            }

        } catch (Exception e) {
            logger.error("forbiddenMap:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "禁用异常", true);
        }

    }

    /*
      创建围栏
     */
    @PostMapping("add")
    public JsonResponse addMapPen(MapDistributionArea mapDistributionArea, List<MapPenCoordinate> mapPenCoordinateList) {

        try {
            mapDistributionArea.setStateId(0);
            Boolean isSuccess = mapDistributionAreaService.saveMapPen(mapDistributionArea, mapPenCoordinateList);
            if (isSuccess) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
            }

        } catch (Exception e) {
            logger.error("addMapPen:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
        }
    }

    /*
    修改围栏
     */
    @PostMapping("update")
    public JsonResponse updateMapPen(MapDistributionArea mapDistributionArea, List<MapPenCoordinate> mapPenCoordinateList) {
        try {
            Boolean isSuccess = mapDistributionAreaService.updateMapPen(mapDistributionArea, mapPenCoordinateList);
            if (isSuccess) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "修改异常", true);
            }
        } catch (Exception e) {
            logger.error("updateMapPen:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "修改异常", true);
        }
    }

    @PostMapping("delete")
    public JsonResponse deleteMapPen(MapDistributionArea mapDistributionArea) {
        try {
            //根据id删除围栏表
            mapDistributionAreaService.delete(mapDistributionArea);
            MapPenCoordinate mapPenCoordinate = new MapPenCoordinate();
            mapPenCoordinate.setAreaId(mapDistributionArea.getId());
            //根据id删除坐标表
            mapPenCoordinateService.delete(mapPenCoordinate);
            return ResponseUtils.setSuccess();
        } catch (Exception e) {
            logger.error("deleteMapPen:" + e.getMessage());
            return ResponseUtils.setToJson(ResponseCode.DELETE_ERROR);
        }

    }

}
