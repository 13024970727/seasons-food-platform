package com.seasonsfood.mall.web.portal.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.GoodsConsignmentWarehouse;
import com.seasonsfood.mall.business.api.service.GoodsConsignmentWarehouseService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.Assert;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consignmentWarehouse")
public class GoodsConsignmentWarehouseController {

    @Reference
    private GoodsConsignmentWarehouseService goodsConsignmentWarehouseService;

    //添加仓库
    @RequestMapping("add")
    public JsonResponse add(String name, Byte stateId) {
        try {
            Assert.hasText(name, "仓库名称不能为空");
            Assert.notNull(stateId, "状态不能为空");
            GoodsConsignmentWarehouse goodsConsignmentWarehouse = new GoodsConsignmentWarehouse();
            goodsConsignmentWarehouse.setWarehouseName(name);
            goodsConsignmentWarehouse.setStateId(stateId);
            goodsConsignmentWarehouseService.save(goodsConsignmentWarehouse);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    //启用/禁用
    @RequestMapping("update")
    public JsonResponse updateById(Integer id, String name, Byte stateId) {
        try {
            GoodsConsignmentWarehouse goodsConsignmentWarehouse = new GoodsConsignmentWarehouse();
            Assert.notNull(id, "数据错误");
            goodsConsignmentWarehouse.setWarehouseId(id);
            goodsConsignmentWarehouse.setWarehouseName(name);
            goodsConsignmentWarehouse.setStateId(stateId);
            goodsConsignmentWarehouseService.updateSelective(goodsConsignmentWarehouse);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    @RequestMapping("list")
    public JsonResponse list(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(goodsConsignmentWarehouseService.findList(pageNum, pageSize));
    }
}
