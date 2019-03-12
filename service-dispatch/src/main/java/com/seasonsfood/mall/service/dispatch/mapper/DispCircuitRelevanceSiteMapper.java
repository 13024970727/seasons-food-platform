package com.seasonsfood.mall.service.dispatch.mapper;

import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;
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
}
