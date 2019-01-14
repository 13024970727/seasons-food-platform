package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "sys_organization_has_sys_user")
public class SysOrganizationHasSysUserKey implements Serializable {

    private static final long serialVersionUID = 1028242446882463188L;

    @Id
    private Long sysOrganizationId;

    @Id
    private Long sysUserId;

    public SysOrganizationHasSysUserKey() {
        super();
    }

    public SysOrganizationHasSysUserKey(Long sysOrganizationId, Long sysUserId) {
        this.sysOrganizationId = sysOrganizationId;
        this.sysUserId = sysUserId;
    }

    public Long getSysOrganizationId() {
        return sysOrganizationId;
    }

    public void setSysOrganizationId(Long sysOrganizationId) {
        this.sysOrganizationId = sysOrganizationId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }
}