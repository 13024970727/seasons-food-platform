package com.seasonsfood.mall.web.map.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.map.api.domain.MapDistributionArea;
import com.seasonsfood.mall.map.api.domain.MapPenCoordinate;
import com.seasonsfood.mall.map.api.domain.MapVillage;
import com.seasonsfood.mall.map.api.service.MapDistributionAreaService;
import com.seasonsfood.mall.map.api.service.MapPenCoordinateService;
import com.seasonsfood.mall.map.api.service.MapVillageService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.GeneralPath;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取小区列表
     *
     * @param villageName 小区名字
     * @param pageNum     页码
     * @param pageSize    页面大小
     * @return 小区列表
     */
    @PostMapping(value = "fandByName")
    public JsonResponse findVillageByName(String villageName, Integer stateId, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(mapVillageService.getVillageList(villageName, stateId, pageNum, pageSize));
    }

    /*
    通过经纬度获取附近小区+判断是否在配送区域
     */
    @PostMapping(value = "selectByLngAndLat")
    public JsonResponse findVillageBylngAndLAT(Double lng, Double lat, Integer pageNum, Integer pageSize) {

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
        if (pageSize == null) {
            pageSize = 10;
        }
        return (ResponseUtils.setSuccess(mapVillageService.getVillageListByLngAndLat(lng, lat, pageNum, pageSize)));
    }


    /*
    判断坐标是否在配送范围
    整和以后放到common.util
     */
    public static boolean check(Point2D.Double point, List<Point2D.Double> polygon) {
        GeneralPath generalPath = new GeneralPath();

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

    /**
     * 添加新的配送地点（如：小区）
     *
     * @param mapVillage 配送地点实体
     * @return
     */
    @PostMapping("addVillage")
    public JsonResponse addVillage(MapVillage mapVillage) {
        try {
            if (mapVillage == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点信息不能为空", true);
            }
            if (mapVillage.getVillageName() == null || !"".equals(mapVillage.getVillageName())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点名称不能为空", true);
            }
            if (mapVillage.getLat() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点纬度不能为空", true);
            }
            if (mapVillage.getLng() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点经度不能为空", true);
            }
            if (mapVillage.getProvince() == null || "".equals(mapVillage.getProvince())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点所属省份不能为空", true);
            }
            if (mapVillage.getCity() == null || "".equals(mapVillage.getCity())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点所属市区不能为空", true);
            }
            if (mapVillage.getDistrict() == null || "".equals(mapVillage.getDistrict())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点所属区县不能为空", true);
            }
            if (mapVillage.getAddress() == null || "".equals(mapVillage.getAddress())) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点详细地址不能为空", true);
            }
            if (mapVillage.getVillageName() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "地点状态不能为空", true);
            }
            Boolean bool = mapVillageService.selectVillage(mapVillage.getVillageName());
            if (bool == true) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "当前地点已存在", true);
            } else {
                int i = mapVillageService.save(mapVillage);
                if (i > 0) {
                    return ResponseUtils.setSuccess();
                } else {
                    return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
                }
            }
        } catch (Exception e) {
            logger.error("addVillage:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "添加异常", true);
        }

    }

    /**
     * 删除小区
     *
     * @param mapVillage
     * @return
     */
    @PostMapping("deleteVillage")
    public JsonResponse deleteVillage(MapVillage mapVillage) {
        try {
            if (mapVillage.getId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择删除地点", true);
            }
            int i = mapVillageService.delete(mapVillage);
            if (i > 0) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "删除失败", true);
            }
        } catch (Exception e) {
            logger.error("deleteVillage:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "删除失败", true);
        }
    }

    /**
     * 修改地点状态
     *
     * @param mapVillage
     * @return
     */
    @PostMapping("updateVillageState")
    public JsonResponse updateVillageState(MapVillage mapVillage) {
        try {
            if (mapVillage == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "修改参数不能为空", true);
            }
            if (mapVillage.getId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择修改地点", true);
            }
            if (mapVillage.getStateId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择修改状态", true);
            }
            Boolean bool = mapVillageService.updateVillageState(mapVillage);
            if (bool == true) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "修改失败", true);
            }
        } catch (Exception e) {
            logger.error("updateVillage:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "修改失败", true);
        }
    }

    /**
     * 修改地点信息
     *
     * @param mapVillage
     * @return
     */
    @PostMapping("updateVillage")
    public JsonResponse updateVillage(MapVillage mapVillage) {

        try {
            if (mapVillage == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "修改参数不能为空", true);
            }
            if (mapVillage.getId() == null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "请选择修改地点", true);
            }
            int i = mapVillageService.update(mapVillage);
            if (i > 0) {
                return ResponseUtils.setSuccess();
            } else {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "修改失败", true);
            }
        } catch (Exception e) {
            logger.error("updateVillage:" + e.getMessage());
            return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "修改失败", true);
        }
    }
}
