package com.seasonsfood.mall.service.dispatch.api.service;
import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuit;
import com.seasonsfood.mall.service.dispatch.api.param.DeliveryUserIdAndOrderId;
import com.seasonsfood.mall.util.constant.ResponseCode;
import com.seasonsfood.mall.util.model.ListResponse;

import java.util.List;

public interface DispCircuitService extends BaseService<DispCircuit> {
    /**
     * @param
     * @author jiangchengwei
     * @date: 2019/3/11-10:50
     * @methodExplain： 修改当日配送顺序
     * @param
     * @return：
     */
    ResponseCode updateDispOrderly(List<DispCircuit> dispCircuit);

    /**
     * @param dispCircuit id 线路id circuitOrderly 线路顺序
     * @author jiangchengwei
     * @date: 2019/3/13-16:28
     * @methodExplain： 修改当日配送顺序
     * @return：
     */
    ResponseCode updateCircuitOrderly(List<DispCircuit> dispCircuit);

    /**
     * @param
     * @author jiangchengwei
     * @date: 2019/3/11-10:49
     * @methodExplain： 查询永久配送线路列表
     * @param
     * @return：
     */
    ListResponse<DispCircuit> selectDispCircuitRecord(Integer pageNum, Integer pageSize, Integer stateId);



    /**
     * @param deliveryUserIdAndOrderId 配送员ID , 订单ID
     * @author jiangchengwei
     * @date: 2019/3/11-10:48
     * @methodExplain： 更换配送员
     * @param deliveryUserIdAndOrderId  配送员ID , 订单ID
     * @return：
     */
    ResponseCode updateDelivery(List<DeliveryUserIdAndOrderId> deliveryUserIdAndOrderId);

    /**
     * @param
     * @author jiangchengwei
     * @date: 2019/3/14-10:28
     * @methodExplain： 统计启用的线路数量
     * @return： java.lang.Integer
     */
    Integer countCircuitNum();
}
