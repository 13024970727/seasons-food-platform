package com.seasonsfood.mall.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seasonsfood.mall.admin.api.domain.SysOrganizationHasSysUserKey;
import com.seasonsfood.mall.admin.api.service.SysOrganizationHasSysUserKeyService;
import com.seasonsfood.mall.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Component;

/**
 *
 * @author ron
 */
@Component
@Service(interfaceClass = SysOrganizationHasSysUserKeyService.class)
public class SysOrganizationHasSysUserKeyServiceImpl extends BaseServiceImpl<SysOrganizationHasSysUserKey> implements SysOrganizationHasSysUserKeyService {

}
