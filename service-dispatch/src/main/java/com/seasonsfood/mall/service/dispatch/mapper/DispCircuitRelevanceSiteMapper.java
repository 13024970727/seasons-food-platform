package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;
import com.seasonsfood.mall.service.dispatch.api.result.RegisterUserNumAndSiteNum;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DispCircuitRelevanceSiteMapper extends Mapper<DispCircuitRelevanceSite> {

    /**
     * @author jiangchengwei
     * @date: 2019/3/11-11:32
     * @methodExplain： 通过地点ID和配送员ID查出线路
     * @param dispatchId 配送员id
     * @param siteId 地点id
     * @return：
     */
    Long selcetDispCircuitId(@Param("dispatchId")Long dispatchId, @Param("siteId")Long siteId);

    /**
     * @param circuitId 线路ID
     * @author jiangchengwei
     * @date: 2019/3/14-10:28
     * @methodExplain： 统计这条线下的配送地点数量
     * @return： java.lang.Integer
     */
    Integer countCircuitDispSite(@Param("circuitId") Long circuitId);

    /**
     * @param circuitId 线路ID
     * @author jiangchengwei
     * @date: 2019/3/14-10:28
     * @methodExplain： 统计这条线下的注册用户数量
     * @return： java.lang.Integer
     */
    Integer countCircuitRegisterUserNum(@Param("circuitId") Long circuitId);

    /**
     * @param
     * @author jiangchengwei
     * @date: 2019/3/14-11:43
     * @methodExplain： 统计启用配送地点数量和注册用户数量
     * @return： RegisterUserNumAndSiteNum
     */
    RegisterUserNumAndSiteNum countRegisterUserNumAndSiteNum();



}
