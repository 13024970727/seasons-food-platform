package com.seasonsfood.mall.service.dispatch.api.service;

import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRecord;
import com.seasonsfood.mall.service.dispatch.api.param.SelectOrderByDelivery;
import com.seasonsfood.mall.service.dispatch.api.result.FontUserOrderInfo;
import com.seasonsfood.mall.service.dispatch.api.result.TodayDispCircuitRecordList;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;


public interface DispCircuitRecordService extends BaseService<DispCircuitRecord> {
    /**jcw
     * 查询今日配送线路列表
     * @param pageNum
     * @param pageSize
     * @param time 查询时间
     * @return
     */
    ListResponse<TodayDispCircuitRecordList> selectTodayDispCircuitRecord (Integer pageNum, Integer pageSize,String time);

    /**jcw
     *查询配送员当前位置
     * @param dispatchId
     * @return
     */
    String selectCircuitLocation(Long dispatchId,String time);

    /**jcw
     * 修改当日配送顺序
     * @param dispCircuitRecord
     * @param time
     * @return
     */
    ResponseCode updateTodayDispOrderly(List<DispCircuitRecord> dispCircuitRecord, String time);
    /**
     * jcw
     * 查看配送员今日配送的订单并通过订单离起点的距离排序
     * @param selectOrderByDelivery
     * @return
     */
    ListResponse<FontUserOrderInfo> selectOrderByDelivery(SelectOrderByDelivery selectOrderByDelivery);




}
