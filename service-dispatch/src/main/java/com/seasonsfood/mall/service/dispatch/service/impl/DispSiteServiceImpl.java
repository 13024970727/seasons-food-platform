package com.seasonsfood.mall.service.dispatch.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispArea;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRelevanceSite;
import com.seasonsfood.mall.service.dispatch.api.domain.DispSite;
import com.seasonsfood.mall.service.dispatch.api.result.LngAndLat;
import com.seasonsfood.mall.service.dispatch.api.service.DispSiteService;
import com.seasonsfood.mall.service.dispatch.mapper.DispAreaMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispCircuitRelevanceSiteMapper;
import com.seasonsfood.mall.service.dispatch.mapper.DispSiteMapper;
import com.seasonsfood.mall.util.constant.ResponseCode;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component("dispSiteService")
@Service(interfaceClass = DispSiteService.class)
public class DispSiteServiceImpl extends BaseServiceImpl<DispSite> implements DispSiteService {


    @Resource
    DispSiteMapper dispSiteMapper;
    @Resource
    DispAreaMapper dispAreaMapper;
    @Resource
    DispCircuitRelevanceSiteMapper dispCircuitRelevanceSiteMapper;

}
