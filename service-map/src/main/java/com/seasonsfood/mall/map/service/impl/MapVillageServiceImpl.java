package com.seasonsfood.mall.map.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.map.api.domain.MapVillage;
import com.seasonsfood.mall.map.api.service.MapVillageService;
import com.seasonsfood.mall.map.mapper.MapVillageMapper;
import com.seasonsfood.mall.util.model.ListResponse;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
    public ListResponse getVillageList(String villageName, Integer stateId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(MapVillage.class);
        Example.Criteria criteria = example.createCriteria();
        if (null != villageName) {
            String inputName = "%" + villageName + "%";
            criteria.andLike("villageName", inputName);
        }
        if (null != stateId) {
            criteria.andEqualTo("stateId", stateId);
        }

        PageInfo<MapVillage> pageInfo = new PageInfo<>(mapVillageMapper.selectByExample(example));
        return new ListResponse(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getPageNum(), pageInfo.getList());

    }

    @Override
    public ListResponse getVillageListByLngAndLat(Double lng, Double lat, Integer pageNum, Integer pageSize) {
        int pageLimit=(pageNum-1)*pageSize;


        PageInfo<MapVillage> pageInfo = new PageInfo<>(mapVillageMapper.selectVillageListByLngAndLat(lng, lat, pageLimit, pageSize), pageNum);

        return new ListResponse(pageInfo);
    }


    /**
     * 查询地点是否存在
     *
     * @param villageName 地点名称
     * @return
     */
    @Override
    public Boolean selectVillage(String villageName) {
        try {
            Example example = new Example(MapVillage.class);
            Example.Criteria criteria = example.createCriteria();
            if (villageName != null) {
                criteria.andEqualTo("villageName", villageName);
            }
            List<MapVillage> mapVillage = mapVillageMapper.selectByExample(example);
            if (mapVillage.size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 修改小区状态
     *
     * @param mapVillage 小区实体
     * @return
     */
    @Override
    public Boolean updateVillageState(MapVillage mapVillage) {
        try {
            Example example = new Example(MapVillage.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", mapVillage.getId());
            mapVillageMapper.updateByExampleSelective(mapVillage, example);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
