package com.seasonsfood.mall.servicemap.api.result;

import java.io.Serializable;

public class MapVertexCoorDinates implements Serializable {
    private  double lng;
    private  double lat;

    public MapVertexCoorDinates() {
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "MapVerTexCoorDinates{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
