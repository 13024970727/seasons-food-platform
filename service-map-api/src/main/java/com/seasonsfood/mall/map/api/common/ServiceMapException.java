package com.seasonsfood.mall.map.api.common;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ServiceMapException extends BaseException implements Serializable{

    private String detailDesc;
    private Object data;

    private String  getErrorInfo(){
        JSONObject errorInfo = new JSONObject();
        errorInfo.put("code",this.getCode());
        errorInfo.put("detailDesc",this.getDetailDesc());
        errorInfo.put("data",this.getData());
        return errorInfo.toJSONString();
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public ServiceMapException(String message,int code) {
        super(message, code);
    }

    public ServiceMapException(String message, int code, String detailDesc, Object data) {
        super(message, code);
        this.detailDesc = detailDesc;
        this.data = data;
    }

    //
    public ServiceMapException(ErrorCode errorCode){
        super(errorCode);
        this.detailDesc = errorCode.getMsg();
    }

    public ServiceMapException(ErrorCode errorCode, String msg){
        super(errorCode.getCode(),errorCode.getMsg()+":"+msg);
        this.detailDesc = msg;
    }

    public ServiceMapException(ErrorCode errorCode, Object data){
        super(errorCode);
        this.detailDesc = errorCode.getMsg();
        this.data = data ;
    }

    public ServiceMapException(ErrorCode errorCode, Throwable cause){
        super(errorCode,cause);
        this.detailDesc = errorCode.getMsg();
    }

    public ServiceMapException(ErrorCode errorCode, Throwable cause, String detailMsg){
        super(errorCode,cause);
        this.detailDesc = errorCode.getMsg() + ":" + detailMsg;
    }

    //
    public ServiceMapException(ErrorCode errorCode, Throwable cause, Object data){
        super(errorCode,cause);
        this.detailDesc = errorCode.getMsg() ;
        this.data = data;
    }

    public ServiceMapException(int code, String detailDesc) {
        super(code);
        this.detailDesc = detailDesc;
    }

    public ServiceMapException(String message, int code, String detailDesc) {
        super(message, code);
        this.detailDesc = detailDesc;
    }

    public ServiceMapException(String message, Throwable cause, int code, String detailDesc) {
        super(message, cause, code);
        this.detailDesc = detailDesc;
    }

    public ServiceMapException(Throwable cause, int code, String detailDesc) {
        super(cause, code);
        this.detailDesc = detailDesc;
    }
}
