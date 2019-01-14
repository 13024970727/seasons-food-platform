package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ron
 */
@Table(name = "sys_organization")
public class SysOrganization implements Serializable {

    private static final long serialVersionUID = 3934771419125971095L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String organizationName;

    private Long parentId;

    private String parentIds;

    private Boolean isAvaliable;

    private Integer orgType;

    private Date createTime;

    public SysOrganization() {
        super();
    }

    public SysOrganization(Long id) {
        this.id = id;
    }

    public SysOrganization(Long id, Boolean isAvaliable) {
        this.id = id;
        this.isAvaliable = isAvaliable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getIsAvaliable() {
        return isAvaliable;
    }

    public void setIsAvaliable(Boolean isAvaliable) {
        this.isAvaliable = isAvaliable;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}