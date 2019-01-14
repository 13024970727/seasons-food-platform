package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ron
 */
@Table(name = "sys_resource")
public class SysResource implements Serializable {

    private static final long serialVersionUID = 3798897494736341174L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceName;

    private String type;

    @OrderBy
    private String priority;

    private Long parentId;

    private String parentIds;

    private String permission;

    private Boolean isAvaliable;

    private String url;

    /**
     * 图标样式
     */
    private String icon;

    public SysResource() {
        super();
    }


    public SysResource(Long id) {
        this.id = id;
    }

    public SysResource(String resourceName) {
        this.resourceName = resourceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Boolean getIsAvaliable() {
        return isAvaliable;
    }

    public void setIsAvaliable(Boolean isAvaliable) {
        this.isAvaliable = isAvaliable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Transient
    private List<SysResource> subMenuList;

    public List<SysResource> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SysResource> subMenuList) {
        this.subMenuList = subMenuList;
    }
}