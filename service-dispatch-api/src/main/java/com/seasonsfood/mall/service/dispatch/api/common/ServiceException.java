package com.seasonsfood.mall.service.dispatch.api.common;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ServiceException extends Exception implements Serializable{

    private String descInfo;
    private Object data;
    private StatusCode statusCode;

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String  getStatusCodeInfo(){
        JSONObject statusInfo = new JSONObject();
        statusInfo.put("code",this.statusCode.getCode());
        statusInfo.put("desc",this.getDescInfo()==null?this.statusCode.getDesc():this.getDescInfo());
        statusInfo.put("isSuccess",this.statusCode.getIsSuccess());
        return statusInfo.toJSONString();
    }


    public ServiceException(StatusCode statusCode){
        this.statusCode = statusCode;
    }

    public ServiceException(StatusCode statusCode, String desc){
        this.statusCode = statusCode;
        this.descInfo = desc;
    }

    public ServiceException(StatusCode statusCode, Object data){
        this.statusCode = statusCode;
        this.descInfo = statusCode.getDesc();
        this.data = data ;
    }

}
