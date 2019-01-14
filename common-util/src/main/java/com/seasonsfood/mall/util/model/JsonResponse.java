package com.seasonsfood.mall.util.model;


public class JsonResponse implements java.io.Serializable {


    /**
     * 状态码：默认200（成功）
     */
    private int code = 200;

    /**
     * 是否请求成功：默认请求失败
     */
    private boolean success = false;

    /**
     * 成功或错误的描述
     */
    private String desc;

    /**
     * 返回的信息
     */
    private Object result;

    public JsonResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
