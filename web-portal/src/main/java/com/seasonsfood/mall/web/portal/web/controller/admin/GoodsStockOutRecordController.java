package com.seasonsfood.mall.web.portal.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.service.GoodsStockOutRecordService;
import com.seasonsfood.mall.business.api.service.UserGoodsOrderService;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockOutRecord")
public class GoodsStockOutRecordController {

    @Reference(check = false)
    GoodsStockOutRecordService goodsStockOutRecordService;
    @Reference(check = false)
    UserGoodsOrderService userGoodsOrderService;

    /**jcw
     * 查找出入库记录
     * @param type
     * @param pageNum
     * @param pageSize
     * @param timeA
     * @param timeB
     * @param sysUserName
     * @return
     */
    @PostMapping(value = "stockOutRecord")
    public JsonResponse selectGoodsCheckRecord(String type,Integer pageNum,Integer pageSize,String timeA,String timeB,String sysUserName) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }

        return ResponseUtils.setSuccess(goodsStockOutRecordService.selecGoodsStockOutRecord( type, pageNum, pageSize, timeA, timeB,sysUserName));

    }

    /**jcw
     * 记录类型
     * @return
     */
    @PostMapping(value = "selectGoodsCheckRecordType")
    public JsonResponse selectGoodsCheckRecordType() {

        return ResponseUtils.setSuccess(goodsStockOutRecordService.selecGoodsStockOutRecordType());

    }

}
