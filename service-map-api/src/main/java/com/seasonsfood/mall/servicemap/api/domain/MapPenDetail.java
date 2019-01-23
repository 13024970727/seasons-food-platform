package com.seasonsfood.mall.servicemap.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="map_pen_detail")
public class MapPenDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long mapPenId ;
    private Integer orderly ;
    private Double lng ;
    private Double lat ;
    private Date create_time ;

    public MapPenDetail() {
        super();
    }

    public MapPenDetail(Long mapPenId, Integer orderly, Double lng, Double lat, Date create_time) {
        this.mapPenId = mapPenId;
        this.orderly = orderly;
        this.lng = lng;
        this.lat = lat;
        this.create_time = create_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMapPenId() {
        return mapPenId;
    }

    public void setMapPenId(Long mapPenId) {
        this.mapPenId = mapPenId;
    }

    public Integer getOrderly() {
        return orderly;
    }

    public void setOrderly(Integer orderly) {
        this.orderly = orderly;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "mapPenDetail{" +
                "id=" + id +
                ", mapPenId=" + mapPenId +
                ", orderly=" + orderly +
                ", lng=" + lng +
                ", lat=" + lat +
                ", create_time=" + create_time +
                '}';
    }
}
