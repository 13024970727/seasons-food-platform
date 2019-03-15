package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.GoodsCheckRecord;
import com.seasonsfood.mall.business.api.model.SelectGoodScheckRecordParam;
import com.seasonsfood.mall.business.api.result.CheckParticulars;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;

import java.math.BigDecimal;
import java.util.Date;

public interface GoodsCheckRecordService extends BaseService<GoodsCheckRecord> {
    //添加寄存商品
    ResponseCode addCheckRecord(GoodsCheckRecord goodsCheckRecord, String remake);

    //从生产日期最早的寄存id开始扣除商品并生成出库记录
    ResponseCode sell(Long goodsId, BigDecimal number);

    //寄存商品退回商家
    ResponseCode sendBack(Long id, BigDecimal number, String remake);

    //寄存商品破损,添加记录
    ResponseCode scrap(Long id, BigDecimal number, String remark);

    /**
     * @author jiangchengwei
     * @date: 2019/3/12-16:16
     * @methodExplain：
     * @param selectGoodScheckRecordParam goodsName 商品名称 shopName   店铺名称 categoryName 分类  saveStateId  库存状态
     *   stateID 展示状态 startTime;//起始时间 endTime;//结束时间
     * @return：
     */
    ListResponse<GoodsCheckRecord> selectGoodScheckRecord(SelectGoodScheckRecordParam selectGoodScheckRecordParam);
    /**jcw
     * 寄存商品信息详情
     * @param checkId 寄存商品ID
     * @return
     */
    CheckParticulars selectCheckInfo(Integer checkId);

}
