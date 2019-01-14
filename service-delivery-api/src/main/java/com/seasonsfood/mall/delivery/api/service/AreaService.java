package com.seasonsfood.mall.delivery.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.delivery.api.domain.Area;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.TreeModel;

import java.util.List;

/**
 * @author Zero
 */
public interface AreaService extends BaseService<Area> {

    /**
     * 创建区域
     * @param area
     * @return
     */
    ResponseCode addArea(Area area);

    /**
     * 修改区域
     * @param area
     * @return
     */
    ResponseCode updateAreaById(Area area);

    /**
     * 删除区域
     * @param id
     * @return
     */
    ResponseCode deleteAreaById(Long id);

    /**
     * 获得区域树
     * @return
     */
    List<TreeModel> getAreaTree();
}
