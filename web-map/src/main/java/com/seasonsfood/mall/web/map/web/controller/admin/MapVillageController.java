package com.seasonsfood.mall.web.map.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.servicemap.api.domain.MapDistributionArea;
import com.seasonsfood.mall.servicemap.api.domain.MapPenCoordinate;
import com.seasonsfood.mall.servicemap.api.service.MapDistributionAreaService;
import com.seasonsfood.mall.servicemap.api.service.MapPenCoordinateService;
import com.seasonsfood.mall.servicemap.api.service.MapVillageService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("village")
public class MapVillageController {

    @Reference(check = false)
    private MapVillageService mapVillageService;

    @Reference(check = false)
    private MapDistributionAreaService mapDistributionAreaService;

    @Reference(check = false)
    private MapPenCoordinateService mapPenCoordinateService;

    /**
     * 获取小区列表
     *
     * @param villageName 小区名字
     * @param pageNum     页码
     * @param pageSize    页面大小
     * @return 小区列表
     */
    @PostMapping(value = "fandByName")
    public JsonResponse findVillageByName(String villageName,Integer stateId, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(mapVillageService.getVillageList(villageName,stateId, pageNum, pageSize));
    }

    /*
    通过经纬度获取附近小区+判断是否在配送区域
     */
    @PostMapping(value = "selectByLngAndLat")
    public JsonResponse findVillageBylngAndLAT(Double lng, Double lat, Integer pageNum) {

        //找到当前正在使用的地图
        MapDistributionArea mapDistributionArea = mapDistributionAreaService.selectByState();
        if (null == mapDistributionArea) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "当前未启用地图", true);
        }
        List<MapPenCoordinate> mapPenCoordinateList = mapPenCoordinateService.selectByAreaId(mapDistributionArea.getId());
        if (mapPenCoordinateList.size() == 0) {
            return ResponseUtils.setToJson(ResponseCode.DATA_ERROR);
        }
        //判断是否在配送范围
        List<Point2D.Double> polygon = new ArrayList<Point2D.Double>();
        for (int i = 0; i < mapPenCoordinateList.size(); i++) {
            Point2D.Double point = new Point2D.Double(mapPenCoordinateList.get(i).getLng(), mapPenCoordinateList.get(i).getLat());
            polygon.add(point);
        }
        Point2D.Double point = new Point2D.Double(lng, lat);
        if (check(point, polygon) == false) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "您当前位置不在配送范围", true);
        }

        if (pageNum == null) {
            pageNum = 1;
        }
        return (ResponseUtils.setSuccess(mapVillageService.getVillageListByLngAndLat(lng, lat, pageNum)));
    }


    /*
    判断坐标是否在配送范围
    整和以后放到common.util
     */
    public static boolean check(Point2D.Double point, List<Point2D.Double> polygon) {
        java.awt.geom.GeneralPath generalPath = new java.awt.geom.GeneralPath();

        Point2D.Double first = polygon.get(0);
        // 通过移动到指定坐标（以双精度指定），将一个点添加到路径中
        generalPath.moveTo(first.x, first.y);
        polygon.remove(0);
        for (Point2D.Double d : polygon) {
            // 通过绘制一条从当前坐标到新指定坐标（以双精度指定）的直线，将一个点添加到路径中。
            generalPath.lineTo(d.x, d.y);
        }
        // 将几何多边形封闭
        generalPath.lineTo(first.x, first.y);
        generalPath.closePath();
        // 测试指定的 Point2D 是否在 Shape 的边界内。
        return generalPath.contains(point);
    }


}
