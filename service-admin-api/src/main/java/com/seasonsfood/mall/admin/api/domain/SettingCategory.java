package com.seasonsfood.mall.admin.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "sys_setting_category")
public class SettingCategory implements Serializable {

    private static final long serialVersionUID = 5648820076155683102L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    /**
     * 类别名
     */
    private String categoryName;
    /**
     * 类别编码
     */
    @OrderBy
    private String categoryCode;
    /**
     * 父类ID
     */
    private Integer parentId;
    /**
     *祖先ID
     */
    private String parentIds;
    /**
     *排序
     */
    private Integer priority;
    /**
     *描述
     */
    private String description;
    /**
     *类别
     */
    private Integer type;

    public SettingCategory() {
        super();
    }

    public SettingCategory(String categoryName, String categoryCode, Integer parentId, String parentIds, Integer priority, String description, Integer type) {
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.priority = priority;
        this.description = description;
        this.type = type;
    }

    public SettingCategory(Integer id) {
        this.id = id;
    }

    public SettingCategory(String code) {
        this.categoryCode = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}