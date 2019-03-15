package com.seasonsfood.mall.service.dispatch.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;
import com.seasonsfood.mall.service.dispatch.api.result.RegisterUserNumAndSiteNum;
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
    /**
     * @author jiangchengwei
     * @date: 2019/3/14-10:38
     * @methodExplain： 统计这条线下的配送地点数量
     * @param circuitId 线路ID
     * @return：java.lang.Integer
     */
    @Override
    public Integer countCircuitDispSite(Long circuitId) {
        Integer count=dispCircuitRelevanceSiteMapper.countCircuitDispSite(circuitId);
        return count;
    }
    /**
     * @author jiangchengwei
     * @date: 2019/3/14-10:38
     * @methodExplain： 统计这条线下的注册用户数量
     * @param circuitId 线路ID
     * @return：java.lang.Integer
     */
    @Override
    public Integer countCircuitRegisterUserNum(Long circuitId) {
        Integer count= dispCircuitRelevanceSiteMapper.countCircuitRegisterUserNum(circuitId);
        return count;
    }
    /**
     * @author jiangchengwei
     * @date: 2019/3/14-11:43
     * @methodExplain： 统计启用配送地点数量和注册用户数量
     * @param
     * @return： RegisterUserNumAndSiteNum
     */
    @Override
    public RegisterUserNumAndSiteNum countRegisterUserNumAndSiteNum() {
        RegisterUserNumAndSiteNum count= dispCircuitRelevanceSiteMapper.countRegisterUserNumAndSiteNum();
        return count;
    }
}
