package com.seasonsfood.mall.service.dispatch.api.service;


import com.seasonsfood.mall.core.service.BaseService;
import com.seasonsfood.mall.service.dispatch.api.domain.DispSite;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;

public interface DispSiteService extends BaseService<DispSite> {
   /* //街道下小区以及注册用户及购买用户
    List<DispSite> getSiteListByStreetId(Long id);

    //列表模式街道下小区
    ListResponse<DispSiteResp> listModelSiteList(DispSiteRequest request);

    //根据地址名找到所在街道
    ListResponse<StreetAndSite> findSiteLocation(String siteName);

    //添加地址
    ResponseCode addDispSite(DispSite dispSite, Long circuitId);
//启用禁用
    ResponseCode enableDisable(DispSite dispSite);*/

    LngAndLat selectLngAndLat( );

}
