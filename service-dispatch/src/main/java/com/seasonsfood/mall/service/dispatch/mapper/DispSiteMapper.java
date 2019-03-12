package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispSite;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DispSiteMapper extends Mapper<DispSite> {

    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:33
     * @methodExplain： 查找订单小区的经纬度
     * @param orderId 订单ID
     * @return：
     */
   LngAndLat selectLngAndLat(@Param("orderId") Long orderId);

    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:33
     * @methodExplain： 通过订单地点找出距离被选配送员所有地点中最近的地点
     * @param dispatchId 配送员
     * @param lng
     * @param lat
     * @return：
     */
    Long findSite(@Param("dispatchId") Long dispatchId,@Param("lng") Double lng,@Param("lat") Double lat);
  /* List<DispSite> getSiteListByStreetId(Long id);
    List<DispSiteResp> listModelSiteList(DispSiteRequest request);
    List<StreetAndSite> findSiteLocation(String siteName);*/

}
