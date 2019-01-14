package com.seasonsfood.mall.business.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.business.api.domain.ShopUserHasSysRoleKey;
import com.seasonsfood.mall.business.api.service.ShopUserBankInfoService;
import com.seasonsfood.mall.business.api.service.ShopUserHasSysRoleService;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author ron
 */
@Component
@Service(interfaceClass = ShopUserHasSysRoleService.class)
public class ShopUserHasSysRoleServiceImpl extends BaseServiceImpl<ShopUserHasSysRoleKey> implements ShopUserHasSysRoleService {

}