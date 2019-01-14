package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.service.TccTestService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ron
 */
@Component
@Service(interfaceClass = TccTestService.class)
public class TccTestServiceImpl implements TccTestService {

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void handleTask1() {

        System.out.println("do task");

    }

    public void handleTask1Confirm(){

        System.out.println("do task confirm");

    }

    public void handleTask1Cancel(){

        System.out.println("do task cancel");

    }

}
