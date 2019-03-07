package com.seasonsfood.mall.service.dispatch.api.result;

import java.io.Serializable;

public class LngAndLat implements Serializable {
    private Double lng;//经度
    private Double lat;//纬度
    public LngAndLat(){super();}

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

    @Override
    public String toString() {
        return "LngAndLat{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
