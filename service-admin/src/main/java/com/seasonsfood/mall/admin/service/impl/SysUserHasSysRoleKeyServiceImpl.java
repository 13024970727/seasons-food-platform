package com.seasonsfood.mall.admin.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.admin.api.domain.SysUserHasSysRoleKey;
import com.seasonsfood.mall.admin.api.service.SysUserHasSysRoleKeyService;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;


/**
 * @author ron
 */
@Component
@Service(interfaceClass = SysUserHasSysRoleKeyService.class)
public class SysUserHasSysRoleKeyServiceImpl extends BaseServiceImpl<SysUserHasSysRoleKey> implements SysUserHasSysRoleKeyService {
}
