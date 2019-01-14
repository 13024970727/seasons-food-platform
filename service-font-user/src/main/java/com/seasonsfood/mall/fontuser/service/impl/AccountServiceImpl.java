package com.seasonsfood.mall.fontuser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.fontuser.api.service.AccountService;

/**
 * @author ron
 */
@Service(interfaceClass = AccountService.class)
public class AccountServiceImpl implements AccountService {

    @Override
    public void accountChange() {
        System.out.println("account change");
    }

    public void accountChangeConfirm() {
        System.out.println("account change");
    }

    public void accountChangeCancel() {
        System.out.println("account change");
    }
}
