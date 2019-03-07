package com.seasonsfood.mall.service.dispatch.api.param;

import java.io.Serializable;

public class SelectOrderByDelivery implements Serializable {
  private   Long dispatchId;
   private Double lng;
   private Double lat;
  private   Integer pageNum;
  private   Integer pageSize;
    public  SelectOrderByDelivery(){
        super();
    }
    public Long getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SelectOrderByDelivery{" +
                "dispatchId=" + dispatchId +
                ", lng=" + lng +
                ", lat=" + lat +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
