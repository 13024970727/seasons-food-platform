package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.admin.api.domain.SysRoleHasSysResourceKey;
import com.seasonsfood.mall.admin.api.service.SysRoleHasSysResourceKeyService;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;


/**
 * @author ron
 */
@Component
@Service(interfaceClass = SysRoleHasSysResourceKeyService.class)
public class SysRoleHasSysResourceKeyServiceImpl extends BaseServiceImpl<SysRoleHasSysResourceKey> implements SysRoleHasSysResourceKeyService {


}
