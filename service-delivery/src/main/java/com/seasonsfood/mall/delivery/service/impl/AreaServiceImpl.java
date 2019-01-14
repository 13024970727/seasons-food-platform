package com.seasonsfood.mall.delivery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.delivery.api.domain.Area;
import com.seasonsfood.mall.delivery.api.service.AreaService;
import com.seasonsfood.mall.delivery.mapper.AreaMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.TreeModel;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zero on 18-12-12
 */
@Service(interfaceClass = AreaService.class)
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {

    @Resource
    AreaMapper areaMapper;

    @Override
    public ResponseCode addArea(Area area) {

        Long pid = area.getParentId();
        Area parentArea = areaMapper.selectByPrimaryKey(pid);

        // 如果没有父节点，设置父节点为0
        if(parentArea == null){
            area.setParentId(0L);
            area.setParentIds("0");
        } else {
            area.setParentIds(parentArea.getParentIds() + "/" + parentArea.getId());
        }

        int count = areaMapper.insertSelective(area);
        if(count <= 0){
            return ResponseCode.ADD_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    @Override
    public ResponseCode updateAreaById(Area area) {
        int count = areaMapper.updateByPrimaryKeySelective(area);
        if(count <= 0){
            return ResponseCode.MODIFY_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    @Override
    public ResponseCode deleteAreaById(Long id) {
        int count = areaMapper.deleteByPrimaryKey(id);
        if(count <= 0){
            return ResponseCode.DELETE_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

    @Override
    public List<TreeModel> getAreaTree() {
        List<Area> areaList = areaMapper.selectAll();
        List<TreeModel> areaTree = new ArrayList<>();
        areaList.forEach(area -> {
            TreeModel treeModel = new TreeModel(area.getId(),area.getParentId(),area.getAreaName());
            areaTree.add(treeModel);
        });
        return areaTree;
    }
}
