package com.seasonsfood.mall.web.portal.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.GoodsMeteringUnit;
import com.seasonsfood.mall.business.api.service.GoodsMeteringUnitService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.Assert;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unit")
public class GoodsMeteringUnitController {


    @Reference(check = false)
    private GoodsMeteringUnitService goodsmeteringUnitService;

    /*
    计量单位列表
     */
    @PostMapping("select")
    public JsonResponse selectMeteringUnitList(String unitName, Byte stateId, Integer pageNum, Integer pageSize) {

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        return ResponseUtils.setSuccess(goodsmeteringUnitService.getMeteringUnitList(unitName, stateId, pageNum, pageSize));

    }

    /*
    修改计量单位
     */
    @PostMapping("update")
    public JsonResponse updateMeteringUnit(GoodsMeteringUnit goodsmeteringUnit) {
        try {
            Assert.notNull(goodsmeteringUnit.getUnitId(), "单位ID不能为空");
            Assert.hasText(goodsmeteringUnit.getUnitName(), "单位名称不能为空");
            GoodsMeteringUnit goodsMeteringUnit1 = new GoodsMeteringUnit();
            goodsMeteringUnit1.setUnitName(goodsmeteringUnit.getUnitName());
            if (goodsmeteringUnitService.selectOne(goodsMeteringUnit1) != null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.MODIFY_ERROR, "已存在该单位");
            }
            goodsmeteringUnitService.updateSelective(goodsmeteringUnit);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.MODIFY_ERROR);
        }
    }

    @PostMapping("add")
    public JsonResponse addMeteringUnit(GoodsMeteringUnit goodsMeteringUnit) {
        try {
            Assert.hasText(goodsMeteringUnit.getUnitName(), "单位名称不能为空");
            if (goodsMeteringUnit.getStateId() == null) {
                goodsMeteringUnit.setStateId((byte) 1);
            }
            if (goodsmeteringUnitService.selectOne(goodsMeteringUnit) != null) {
                return ResponseUtils.setJsonAndMsg(ResponseCode.ADD_ERROR, "已存在该单位");
            }
            goodsmeteringUnitService.saveSelective(goodsMeteringUnit);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setToJson(ResponseCode.ADD_ERROR);
        }
    }

    /*
    根据id修改状态
     */
    @PostMapping("updateState")
    public JsonResponse updateStateById(Integer unitId, Byte stateId) {
        try {
            Assert.notNull(unitId, "单位ID不能为空");
            Assert.notNull(stateId, "状态ID不能为空");
            GoodsMeteringUnit goodsMeteringUnit = new GoodsMeteringUnit();
            goodsMeteringUnit.setStateId(stateId);
            goodsMeteringUnit.setUnitId(unitId);
            goodsmeteringUnitService.updateSelective(goodsMeteringUnit);
            return ResponseUtils.setSuccess();
        } catch (NumberFormatException e) {
            return ResponseUtils.setToJson(ResponseCode.FORMAT_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.setJsonAndMsg(ResponseCode.OTHER_ERROR, "操作失败");
        }
    }
}
