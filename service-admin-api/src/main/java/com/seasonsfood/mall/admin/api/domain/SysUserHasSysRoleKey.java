package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "sys_user_has_sys_role")
public class SysUserHasSysRoleKey implements Serializable {

    private static final long serialVersionUID = 2610190955625787112L;

    @Id
    private Long sysUserId;

    @Id
    private Long sysRoleId;

    public SysUserHasSysRoleKey() {
       super();
    }

    public SysUserHasSysRoleKey(Long sysUserId, Long sysRoleId) {
        this.sysUserId = sysUserId;
        this.sysRoleId = sysRoleId;
    }

    public SysUserHasSysRoleKey(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}