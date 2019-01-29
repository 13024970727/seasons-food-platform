package com.seasonsfood.mall.map.api.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "map_village")
public class MapVillage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//
    private String villageName;//小区名字
    private Double lng;//经度
    private Double lat;//纬度
    private String province;//省份
    private String city;//城市
    private String district;//区/县
    private String address;//地址
    private Byte stateId;//0未启用,1启用,2删除

    public MapVillage() {
        super();
    }


    @Override
    public String toString() {
        return "MapVillage{" +
                "id=" + id +
                ", villageName='" + villageName + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getStateId() {
        return stateId;
    }

    public void setStateId(Byte stateId) {
        this.stateId = stateId;
    }
}
