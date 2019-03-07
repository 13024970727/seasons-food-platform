package com.seasonsfood.mall.business.api.service;

import com.seasonsfood.mall.business.api.domain.GoodsCheckRecord;
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
    ListResponse<GoodsCheckRecord> selectGoodScheckRecord(String goodsName, String shopName, String goodsCategoryName, Integer categoryId, Integer stateId, Integer saveStateId, Date time, Integer pageNum, Integer pageSize);
    /**jcw
     * 寄存商品信息详情
     * @param checkId 寄存商品ID
     * @return
     */
    CheckParticulars selectCheckInfo(Integer checkId);

}
