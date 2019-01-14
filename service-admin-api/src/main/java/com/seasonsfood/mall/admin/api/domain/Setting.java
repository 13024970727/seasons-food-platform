package com.seasonsfood.mall.admin.api.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ron
 */
@Table(name = "sys_setting")
public class Setting implements Serializable {

    private static final long serialVersionUID = -2277975309605999608L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OrderBy
    private Integer priority;

    private String code;

    private String sysName;

    private String sysValue;

    private String extendValue1;

    private String extendValue2;

    private String sysDescription;

    private Boolean isShow;

    private Integer categoryId;


    public Setting() {
        super();
    }

    public Setting(Long id) {
        this.id = id;
    }

    public Setting(String code,String sysValue) {
        this.priority = 0;
        this.code = code;
        this.sysName = "sys_setting";
        this.sysValue = sysValue;
        this.sysDescription = "系统内部逻辑使用属性";
        this.isShow = false;
        this.categoryId = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysValue() {
        return sysValue;
    }

    public void setSysValue(String sysValue) {
        this.sysValue = sysValue;
    }

    public String getExtendValue1() {
        return extendValue1;
    }

    public void setExtendValue1(String extendValue1) {
        this.extendValue1 = extendValue1;
    }

    public String getExtendValue2() {
        return extendValue2;
    }

    public void setExtendValue2(String extendValue2) {
        this.extendValue2 = extendValue2;
    }

    public String getSysDescription() {
        return sysDescription;
    }

    public void setSysDescription(String sysDescription) {
        this.sysDescription = sysDescription;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}