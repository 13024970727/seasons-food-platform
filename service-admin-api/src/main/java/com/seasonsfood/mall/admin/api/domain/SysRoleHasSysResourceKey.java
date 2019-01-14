package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "sys_role_has_sys_resource")
public class SysRoleHasSysResourceKey implements Serializable {

    private static final long serialVersionUID = -1790487597566927834L;

    @Id
    private Long sysRoleId;

    @Id
    private Long sysResourceId;

    public SysRoleHasSysResourceKey() {
        super();
    }

    public SysRoleHasSysResourceKey(Long sysRoleId, Long sysResourceId) {
        this.sysRoleId = sysRoleId;
        this.sysResourceId = sysResourceId;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public Long getSysResourceId() {
        return sysResourceId;
    }

    public void setSysResourceId(Long sysResourceId) {
        this.sysResourceId = sysResourceId;
    }
}