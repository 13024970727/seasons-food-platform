package com.seasonsfood.mall.service.dispatch.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispDispatchCircuit;
import com.seasonsfood.mall.service.dispatch.api.service.DispDispatchCircuitService;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = DispDispatchCircuitService.class)
public class DispDispatchCircuitServiceImpl extends BaseServiceImpl<DispDispatchCircuit> implements DispDispatchCircuitService {
}
