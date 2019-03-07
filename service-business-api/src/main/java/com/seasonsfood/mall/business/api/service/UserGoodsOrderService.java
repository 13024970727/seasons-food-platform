package com.seasonsfood.mall.business.api.service;


import com.seasonsfood.mall.business.api.domain.UserGoodsOrder;
import com.seasonsfood.mall.core.service.BaseService;

/**
 * @Author zhaozhirong
 * @Date 2018年12月17日10:44:13
 * 用户订单接口
 */
public interface UserGoodsOrderService extends BaseService<UserGoodsOrder> {
   /**jcw
     * 区域管理
     * 统计未分配配送员的订单数量
     * @return
     */
   // int selectNoDeliveryNum();


    /**jcw
     *更换配送员
    * @param userGoodsOrder  配送员ID , 订单ID
     * @return
     */
   // ResponseCode updateDelivery(List<UserGoodsOrder> userGoodsOrder);
}