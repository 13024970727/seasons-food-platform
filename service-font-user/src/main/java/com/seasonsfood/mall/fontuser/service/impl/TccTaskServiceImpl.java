package com.seasonsfood.mall.fontuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.fontuser.api.service.TccTaskService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ron
 */
@Component("tccTaskService")
@Service(interfaceClass = TccTaskService.class)
public class TccTaskServiceImpl implements TccTaskService {


    @Override
    @Transactional
    public void task() {
        System.out.println("do task");
    }

    public void taskConfirm() {
        System.out.println("Confirm task");

    }

    public void taskCancel() {
        System.out.println("Cancel task");


    }
}
