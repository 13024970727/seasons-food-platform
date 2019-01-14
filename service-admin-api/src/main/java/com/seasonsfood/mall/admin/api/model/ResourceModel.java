package com.seasonsfood.mall.admin.api.model;

import java.util.List;

/**
 * @author ron
 */
public class ResourceModel {
    private String name;
    private String icon;
    private String url;
    private List<ResourceModel> subMenuList;

    public ResourceModel(String name, String icon, String url) {
        this.name = name;
        this.icon = icon;
        this.url = url;
    }

    public ResourceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ResourceModel> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<ResourceModel> subMenuList) {
        this.subMenuList = subMenuList;
    }
}
