package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.business.api.domain.UserGoodsOrder;
import com.seasonsfood.mall.service.dispatch.api.domain.DispDispatchCircuit;
import com.seasonsfood.mall.util.constant.ResponseCode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DispDispCircuitMapper extends Mapper<DispDispatchCircuit> {

    /**jcw
     * 区域管理
     * 统计未分配配送员的订单数量
     * @return
     */
    int selectNoDeliveryNum();

    /**jcw
     *更换配送员
     * @param userGoodsOrder  配送员ID , 订单ID
     * @return
     */
    ResponseCode updateDelivery(List<UserGoodsOrder> userGoodsOrder);
}
