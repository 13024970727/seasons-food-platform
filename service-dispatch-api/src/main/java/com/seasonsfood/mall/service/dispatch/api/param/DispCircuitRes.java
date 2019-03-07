package com.seasonsfood.mall.service.dispatch.api.param;

public class DispCircuitRes {
    /**
     * 起点经度
     */
    Double originLng;
    /**
     * 起点纬度
     */
    Double originLat;
    /**
     * 终点经度
     */
    Double destinationLng;
    /**
     * 终点纬度
     */
    Double destinationlat;
    public DispCircuitRes(){
        super();
    }

    public Double getOriginLng() {
        return originLng;
    }

    public void setOriginLng(Double originLng) {
        this.originLng = originLng;
    }

    public Double getOriginLat() {
        return originLat;
    }

    public void setOriginLat(Double originLat) {
        this.originLat = originLat;
    }

    public Double getDestinationLng() {
        return destinationLng;
    }

    public void setDestinationLng(Double destinationLng) {
        this.destinationLng = destinationLng;
    }

    public Double getDestinationlat() {
        return destinationlat;
    }

    public void setDestinationlat(Double destinationlat) {
        this.destinationlat = destinationlat;
    }

    @Override
    public String toString() {
        return "DispCircuitRes{" +
                "originLng=" + originLng +
                ", originLat=" + originLat +
                ", destinationLng=" + destinationLng +
                ", destinationlat=" + destinationlat +
                '}';
    }
}
