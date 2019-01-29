package com.seasonsfood.mall.map.api.common;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public enum ErrorCode implements Serializable{

    /**错误代码范围 2000-2999*/
    MAP_PEN_CREATE_ENTER_PARAM_NULL(2000,"创建配送员地图围栏接口-入参数不能为空",false);

    private Integer code;
    private String msg;
    private Boolean isSuccess;

    ErrorCode(Integer code, String msg, Boolean isSuccess) {
        this.code = code;
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    @Override
    public String toString() {
        JSONObject errorCode = new JSONObject();
        errorCode.put("code",this.getCode());
        errorCode.put("msg",this.getMsg());
        errorCode.put("",this.isSuccess);
        return errorCode.toJSONString();
    }
}
