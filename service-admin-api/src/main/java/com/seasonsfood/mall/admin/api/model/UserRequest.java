package com.seasonsfood.mall.admin.api.model;


import com.seasonsfood.mall.util.model.PageRequest;

/**
 *
 * @author ron
 */
public class UserRequest extends PageRequest {


    private String username;
    private String name;
    private Integer orgId;
    private Integer userType;
    private String idCard;
    private Boolean isBind;
    private Boolean isApprove;
    /**
     * 是否锁定：1为锁定，2为不锁定
     */
    private Integer lock;

    /**
     * 是否锁定：0为全部，1为已加入部门，2为未加入部门
     */
    private Integer org;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Boolean getIsBind() {
        return isBind;
    }

    public void setIsBind(Boolean bind) {
        isBind = bind;
    }

    public Boolean getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Boolean approve) {
        isApprove = approve;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
