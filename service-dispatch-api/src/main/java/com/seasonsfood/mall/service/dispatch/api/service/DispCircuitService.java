package com.seasonsfood.mall.service.dispatch.api.service;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import com.seasonsfood.mall.service.dispatch.api.param.DeliveryUserIdAndOrderId;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

public interface DispCircuitService extends BaseService<DispCircuit> {
    /**jcw
     * 修改当日配送顺序
     * @param dispCircuit
     * @return
     */
    ResponseCode updateDispOrderly(List<DispCircuit> dispCircuit);
    /**
     * jcw
     * 查询永久配送线路列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    ListResponse<DispCircuit> selectDispCircuitRecord (Integer pageNum, Integer pageSize,Integer stateId);


    /**jcw
     * 区域管理
     * 统计未分配配送员的订单数量
     * @return
     */
   int selectNoDeliveryNum();


    /**jcw
     *更换配送员
     * @param deliveryUserIdAndOrderId  配送员ID , 订单ID
     * @return
     */
    ResponseCode updateDelivery(List<DeliveryUserIdAndOrderId> deliveryUserIdAndOrderId);
}
