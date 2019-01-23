package com.seasonsfood.mall.servicemap.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.servicemap.api.domain.MapDistributionArea;
import com.seasonsfood.mall.servicemap.api.domain.MapPenCoordinate;
import com.seasonsfood.mall.servicemap.api.result.MapVertexCoorDinates;
import com.seasonsfood.mall.servicemap.api.service.MapDistributionAreaService;
import com.seasonsfood.mall.servicemap.mapper.MapDistributionAreaMapper;
import com.seasonsfood.mall.servicemap.mapper.MapPenCoordinateMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Component("mapDistributionAreaService")
@Service(interfaceClass = MapDistributionAreaService.class)
public class MapDistributionAreaServiceImpl extends BaseServiceImpl<MapDistributionArea> implements MapDistributionAreaService {

    @Resource
    private MapDistributionAreaMapper mapDistributionAreaMapper;

    @Resource
    private MapPenCoordinateMapper mapPenCoordinateMapper;


    @Override
    public MapDistributionArea selectByState() {
        MapDistributionArea mapDistributionArea = mapDistributionAreaMapper.selectByState();
        return mapDistributionArea;
    }

    @Override
    public ListResponse<MapDistributionArea> getMapPenList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(MapDistributionArea.class);
        //Example.Criteria criteria = example.createCriteria();
        PageInfo<MapDistributionArea> pageInfo = new PageInfo<>(mapDistributionAreaMapper.selectByExample(example));
        return new ListResponse(pageInfo);
    }

    @Override
    public Boolean startUsingMapPen(Integer id) {
        try {
            //先禁用正在启用围栏
            mapDistributionAreaMapper.forbiddenAll();
            //再启用当前围栏
            mapDistributionAreaMapper.startUsing(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //禁用围栏
    @Override
    public Boolean forbiddenMapPen(Integer id) {
        try {
            mapDistributionAreaMapper.forbiddenNowaday(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean saveMapPen(MapDistributionArea mapDistributionArea, List<MapPenCoordinate> mapPenCoordinateList) {
        try {
            mapDistributionAreaMapper.insertSelective(mapDistributionArea);
            for (int i = 0; i < mapPenCoordinateList.size(); i++) {
                MapPenCoordinate mapPenCoordinate = new MapPenCoordinate();
                mapPenCoordinate.setLng(mapPenCoordinateList.get(i).getLng());
                mapPenCoordinate.setLat(mapPenCoordinateList.get(i).getLat());
                mapPenCoordinate.setAreaId(mapDistributionArea.getId());
                mapPenCoordinate.setSortRankId(i);
                mapPenCoordinateMapper.insert(mapPenCoordinate);

            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateMapPen(MapDistributionArea mapDistributionArea, List<MapPenCoordinate> mapPenCoordinateList) {

        try {
            mapDistributionAreaMapper.updateByPrimaryKeySelective(mapDistributionArea);
            MapPenCoordinate mapPenCoordinate = new MapPenCoordinate();
            mapPenCoordinate.setAreaId(mapDistributionArea.getId());
            //根据id删除坐标表
            mapPenCoordinateMapper.delete(mapPenCoordinate);

            for (int i = 0; i < mapPenCoordinateList.size(); i++) {
                mapPenCoordinate=new MapPenCoordinate();
                mapPenCoordinate.setAreaId(mapDistributionArea.getId());
                mapPenCoordinate.setLng(mapPenCoordinateList.get(i).getLng());
                mapPenCoordinate.setLat(mapPenCoordinateList.get(i).getLat());
                mapPenCoordinate.setSortRankId(i+1);
                mapPenCoordinateMapper.insertSelective(mapPenCoordinate);
            }
            return true;
        } catch (Exception e) {
            return false;
        }


    }
}
