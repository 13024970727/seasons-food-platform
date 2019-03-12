package com.seasonsfood.mall.service.dispatch.api.service;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import com.seasonsfood.mall.service.dispatch.api.param.DeliveryUserIdAndOrderId;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

public interface DispCircuitService extends BaseService<DispCircuit> {
    /**
     * @author jiangchengwei
     * @date: 2019/3/11-10:50
     * @methodExplain： 修改当日配送顺序
     * @param
     * @return：
     */
    ResponseCode updateDispOrderly(List<DispCircuit> dispCircuit);
    /**
     * @author jiangchengwei
     * @date: 2019/3/11-10:49
     * @methodExplain： 查询永久配送线路列表
     * @param
     * @return：
     */
    ListResponse<DispCircuit> selectDispCircuitRecord (Integer pageNum, Integer pageSize,Integer stateId);



    /**
     * @author jiangchengwei
     * @date: 2019/3/11-10:48
     * @methodExplain： 更换配送员
     * @param deliveryUserIdAndOrderId  配送员ID , 订单ID
     * @return：
     */
    ResponseCode updateDelivery(List<DeliveryUserIdAndOrderId> deliveryUserIdAndOrderId);
}
