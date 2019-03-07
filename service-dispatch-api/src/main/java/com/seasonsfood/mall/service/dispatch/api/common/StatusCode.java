package com.seasonsfood.mall.service.dispatch.api.common;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public enum StatusCode implements Serializable{

    /**错误代码范围 2000-2999*/
    SUCCESS(200,"成功",true),
    SUCCESS_UNTREATED(202,"请求成功，但处理失败",false),
    PARAM_NULL(1001,"参数不能为空",false),
    DATE_REPETI(1002,"数据重复",false),
    DATE_NOT_EXIST(1003,"数据不存在",false),
    PARAM_ERROR(1003,"参数错误",false);

    private Integer code;
    private String desc;
    private Boolean isSuccess;

    StatusCode(Integer code, String desc, Boolean isSuccess) {
        this.code = code;
        this.desc = desc;
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        JSONObject statusCode = new JSONObject();
        statusCode.put("code",this.getCode());
        statusCode.put("desc",this.getDesc());
        statusCode.put("isSuccess",this.isSuccess);
        return statusCode.toJSONString();
    }
}
