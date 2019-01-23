package com.seasonsfood.mall.servicemap.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.servicemap.api.domain.MapVillage;
import com.seasonsfood.mall.servicemap.api.service.MapVillageService;
import com.seasonsfood.mall.servicemap.mapper.MapVillageMapper;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 */
@Component("mapVillageService")
@Service(interfaceClass = MapVillageService.class)
public class MapVillageServiceImpl extends BaseServiceImpl<MapVillage> implements MapVillageService {
    @Resource
    private MapVillageMapper mapVillageMapper;



    @Override
    public ListResponse getVillageList(String villageName,Integer stateId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(MapVillage.class);
        Example.Criteria criteria = example.createCriteria();
        if(null!=villageName){
            String inputName="%"+villageName+"%";
            criteria.andLike("villageName",inputName);
        }if (null !=stateId){
            criteria.andEqualTo("stateId",stateId);
        }

        PageInfo<MapVillage> pageInfo = new PageInfo<>(mapVillageMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getPageNum(),pageInfo.getList());

    }

    @Override
    public ListResponse getVillageListByLngAndLat(Double lng, Double lat,Integer pageNum) {
        double di=0.2;// 0.5千米距离
        double r = 6371;// 地球半径千米
        double dis = di*pageNum;// 下拉一次加两百米
        double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(lat * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;// 角度转为弧度
        double dlat = dis / r;
        dlat = dlat * 180 / Math.PI;
        double minlat = lat - dlat;
        double maxlat = lat + dlat;
        double minlng = lng - dlng;
        double maxlng = lng + dlng;

        PageInfo<MapVillage> pageInfo = new PageInfo<>(mapVillageMapper.selectVillageListByLngAndLat(minlng,maxlng,minlat,maxlat));
        return new ListResponse(pageInfo);
    }




}
