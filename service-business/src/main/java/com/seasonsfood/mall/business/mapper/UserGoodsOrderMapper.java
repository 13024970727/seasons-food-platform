package com.seasonsfood.mall.business.mapper;

import com.seasonsfood.mall.business.api.domain.UserGoodsOrder;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author ron
 */
public interface UserGoodsOrderMapper extends Mapper<UserGoodsOrder> {
    /**jcw
     * 查找订单小区的经纬度
     * @param orderId 订单ID
     * @return
     */
   // LngAndLat selectLngAndLat(@Param("orderId") Long orderId);
}