package com.seasonsfood.mall.admin.mapper;

import com.seasonsfood.mall.admin.api.domain.SysOrganizationHasSysUserKey;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ron
 */
public interface SysOrganizationHasSysUserMapper extends Mapper<SysOrganizationHasSysUserKey> {

    /**
     * 通过用户编号查找
     *
     * @param uid
     *         用户编号
     *
     * @return
     */
    List<SysOrganizationHasSysUserKey> findByUid(Long uid);

    /**
     * 通过组织编号查找
     *
     * @param orgId
     *         组织编号
     *
     * @return
     */
    List<SysOrganizationHasSysUserKey> findByOrgId(Long orgId);
}