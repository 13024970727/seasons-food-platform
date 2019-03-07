package com.seasonsfood.mall.service.dispatch.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import com.seasonsfood.mall.service.dispatch.api.domain.DispCircuitRecordImage;
import com.seasonsfood.mall.service.dispatch.api.service.DispCircuitRecordImageService;

import org.springframework.stereotype.Component;



@Component
@Service(interfaceClass = DispCircuitRecordImageService.class)
public class DispCircuitRecordImageImpl extends BaseServiceImpl<DispCircuitRecordImage> implements DispCircuitRecordImageService {

}
