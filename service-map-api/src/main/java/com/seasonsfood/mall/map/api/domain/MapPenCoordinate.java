package com.seasonsfood.mall.map.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 区域围栏坐标
 */
public class MapPenCoordinate implements Serializable {
    /**
     * 坐标id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 经度
     */
    private Double lng;
    /**
     * 纬度
     */
    private Double lat;
    /**
     * 配送区域ID
     */
    private Integer areaId;
    /**
     * 排序ID
     */
    private Integer sortRankId;
public MapPenCoordinate(){
    super();
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getSortRankId() {
        return sortRankId;
    }

    public void setSortRankId(Integer sortRankId) {
        this.sortRankId = sortRankId;
    }
}
