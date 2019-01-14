package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ron
 */
@Table(name = "sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = -1195268809826762668L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    private String description;

    private String resourceIds;

    private Boolean isAvaliable;

    @Transient
    private List<SysResource> sysResources;

    @Transient
    private String sysResourceNames;

    public SysRole() {
        super();
    }

    public SysRole(Long id) {
        this.id = id;
    }

    public List<SysResource> getSysResources() {
        return sysResources;
    }

    public void setSysResources(List<SysResource> sysResources) {
        this.sysResources = sysResources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Boolean getIsAvaliable() {
        return isAvaliable;
    }

    public void setIsAvaliable(Boolean isAvaliable) {
        this.isAvaliable = isAvaliable;
    }
    public String getSysResourceNames() {
        String names = "";
        if (this.sysResources != null ){
            if (this.sysResources.size() != 0){
                for (SysResource sysResource : sysResources){
                    names = names + sysResource.getResourceName() + ",";
                }
            }
        }
        return names;
    }

    public void setSysResourceNames(String sysResourceNames) {
        this.sysResourceNames = sysResourceNames;
    }
}