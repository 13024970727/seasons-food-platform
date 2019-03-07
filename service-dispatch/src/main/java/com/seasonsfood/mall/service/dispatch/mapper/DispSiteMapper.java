package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispSite;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DispSiteMapper extends Mapper<DispSite> {

    /**jcw
     * 查找订单小区的经纬度
     * @param orderId 订单ID
     * @return
     */
   LngAndLat selectLngAndLat(@Param("orderId") Long orderId);

    /**
     *
     * @param dispatchId 配送员
     * @param lng
     * @param lat
     * @return
     */
    Long findSite(@Param("dispatchId") Long dispatchId,@Param("lng") Double lng,@Param("lat") Double lat);
  /* List<DispSite> getSiteListByStreetId(Long id);
    List<DispSiteResp> listModelSiteList(DispSiteRequest request);
    List<StreetAndSite> findSiteLocation(String siteName);*/

}
