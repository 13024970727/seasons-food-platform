package com.seasonsfood.mall.service.dispatch.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitRelevanceSiteService;
import com.seasonsfood.mall.service.dispatch.mapper.DispCircuitRelevanceSiteMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Component
@Service(interfaceClass = DispCircuitRelevanceSiteService.class)
public class DispCircuitRelevanceSiteImpl extends BaseServiceImpl<DispCircuitRelevanceSite> implements DispCircuitRelevanceSiteService {
    @Resource
    DispCircuitRelevanceSiteMapper dispCircuitRelevanceSiteMapper;
    /**
     * @author jiangchengwei
     * @date: 2019/3/11-10:50
     * @methodExplain： 配送线路添加地点
     * @param dispCircuitRelevanceSite
     * @return：
     */
    @Override
    public Integer addDispCircuitRelevanceSite(List<DispCircuitRelevanceSite> dispCircuitRelevanceSite) {

        Integer success=null;
        for (int i = 0; i < dispCircuitRelevanceSite.size(); i++) {
            if (dispCircuitRelevanceSite.get(i).getIsStart() == null) {
                dispCircuitRelevanceSite.get(i).setIsStart(1);
            }
            dispCircuitRelevanceSite.get(i).setCreateTime(new Date());
             success = dispCircuitRelevanceSiteMapper.insertSelective(dispCircuitRelevanceSite.get(i));
        }
        return success;
    }
}
