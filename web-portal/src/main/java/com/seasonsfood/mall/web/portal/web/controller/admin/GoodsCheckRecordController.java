package com.seasonsfood.mall.web.portal.web.controller.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.business.api.domain.GoodsCheckRecord;
import com.seasonsfood.mall.business.api.service.GoodsCheckRecordService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.exception.BizException;
import com.seasonsfood.mall.util.model.JsonResponse;
import com.seasonsfood.mall.util.util.Assert;
import com.seasonsfood.mall.util.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("checkRecord")
public class GoodsCheckRecordController {

    @Reference(check = false)
    private GoodsCheckRecordService goodsCheckRecordService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //添加寄存商品
    @RequestMapping("add")
    public JsonResponse addCheckRecord(GoodsCheckRecord goodsCheckRecord, String remark) {
        Assert.notNull(goodsCheckRecord.getGoodsId(), "寄存商品不能为空");
        goodsCheckRecord.setResponsiblePersonId((long) 10001);
        goodsCheckRecord.setWarehouseEntryTime(new Date());
        goodsCheckRecord.setStateId(1);
        Assert.notNull(goodsCheckRecord.getWarehouseId(), "请选择寄存仓库");
        if (goodsCheckRecord.getRegisterFee() == null) {
            goodsCheckRecord.setRegisterFee(BigDecimal.valueOf(0));
        }
        if (goodsCheckRecord.getDateInProduced() == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_DATA, "生产日期不能为空", true);
        }
        // Assert.notNull(goodsCheckRecord.getDateInProduced(),"生产日期不能为空");
        Assert.notNull(goodsCheckRecord.getExpirationDate(), "保质期不能为空");
        Assert.notNull(goodsCheckRecord.getQuantityInStock(), "寄存数量不能为空");
        Assert.notNull(goodsCheckRecord.getUnitId(), "计量单位不能为空");
        Assert.notNull(goodsCheckRecord.getDeadlineWarning(), "保质期预警不能为空");
        Assert.notNull(goodsCheckRecord.getUnitId(), "库存预警不能为空");
        ResponseCode responseCode = goodsCheckRecordService.addCheckRecord(goodsCheckRecord, remark);

        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }

    //出售
    @RequestMapping("sell")
    public JsonResponse sell(Long goodsId, BigDecimal number) {
        ResponseCode responseCode = goodsCheckRecordService.sell(goodsId, number);
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }

    //退还商家
    @RequestMapping("sendBack")
    public JsonResponse sendBack(Long id, BigDecimal number, String remark) {
        ResponseCode responseCode = goodsCheckRecordService.sendBack(id, number, remark);
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }

    //寄存商品破损报废
    @RequestMapping("scrap")
    public JsonResponse scrap(Long id, BigDecimal number, String remark) {
        ResponseCode responseCode = goodsCheckRecordService.scrap(id, number, remark);
        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            throw new BizException(responseCode);
        }
        return ResponseUtils.setSuccess(responseCode);
    }



    /**jcw
     * 寄存商品列表
     * @param goodsName  商品名称
     * @param shopName   店铺名称
     * @param categoryId 分类ID
     * @param stateId    库存状态
     * @param time       时间
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "selectGoodsCheckRecord")
    public JsonResponse selectGoodsCheckRecord(String goodsName, String shopName,String goodsCategoryName, Integer categoryId, Integer stateId, Integer saveStateId,Date time, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 2;
        }
        if (stateId == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "寄存状态不能为空", true);
        }
        return ResponseUtils.setSuccess(goodsCheckRecordService.selectGoodScheckRecord( goodsName,  shopName,goodsCategoryName, categoryId,  stateId, saveStateId,  time,  pageNum,  pageSize));

    }

    /**jcw
     * 寄存商品信息详情
     * @param checkId 寄存商品ID
     * @return
     */
    @PostMapping(value = "selectCheckInfo")
    public JsonResponse selectCheckInfo(Integer checkId) {

        if (checkId == null) {
            return ResponseUtils.setJsonAndMsg(ResponseCode.NOT_NULL, "寄存商品ID不能为空", true);
        }
        return ResponseUtils.setSuccess(goodsCheckRecordService.selectCheckInfo(checkId));

    }


}
