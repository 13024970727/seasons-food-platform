package com.seasonsfood.mall.map.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="map_pen")
public class MapPen implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer penDispatchType;
    private Long dispatch_id;
    private String dispatch_name;
    private String province;
    private String city;
    private String area;
    private Integer isStart;
    private Integer isDel;
    private Date create_time;

    public MapPen() {
        super();
    }

    public MapPen(Integer penDispatchType, Long dispatch_id, String dispatch_name, String province, String city, String area, Integer isStart, Integer isDel, Date create_time) {
        this.penDispatchType = penDispatchType;
        this.dispatch_id = dispatch_id;
        this.dispatch_name = dispatch_name;
        this.province = province;
        this.city = city;
        this.area = area;
        this.isStart = isStart;
        this.isDel = isDel;
        this.create_time = create_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPenDispatchType() {
        return penDispatchType;
    }

    public void setPenDispatchType(Integer penDispatchType) {
        this.penDispatchType = penDispatchType;
    }

    public Long getDispatch_id() {
        return dispatch_id;
    }

    public void setDispatch_id(Long dispatch_id) {
        this.dispatch_id = dispatch_id;
    }

    public String getDispatch_name() {
        return dispatch_name;
    }

    public void setDispatch_name(String dispatch_name) {
        this.dispatch_name = dispatch_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "mapPen{" +
                "id=" + id +
                ", penDispatchType=" + penDispatchType +
                ", dispatch_id=" + dispatch_id +
                ", dispatch_name='" + dispatch_name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", isStart=" + isStart +
                ", isDel=" + isDel +
                ", create_time=" + create_time +
                '}';
    }
}
