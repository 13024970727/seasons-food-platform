package com.seasonsfood.mall.map.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 配送区域
 */
public class MapDistributionArea implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "JDBC")//此处加上注解
    private Integer id;

    /**
     * 配送区域名称
     */
    private String areaName;
    /**
     * 排序ID(优先级)
     */
    private Integer sortRankId;
    /*
     *状态0未启用/1启用
     */
    private Integer stateId;

    public MapDistributionArea() {
        super();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getSortRankId() {
        return sortRankId;
    }

    public void setSortRankId(Integer sortRankId) {
        this.sortRankId = sortRankId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
}
