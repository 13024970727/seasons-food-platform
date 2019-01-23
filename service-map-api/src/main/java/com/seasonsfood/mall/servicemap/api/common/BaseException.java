package com.seasonsfood.mall.servicemap.api.common;



import java.io.Serializable;

public class BaseException extends Exception implements Serializable{

    private int code;
    private String msg;
    private ErrorCode errorCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public BaseException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, Throwable cause){
        super(cause);
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, String msg){
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public BaseException(int code) {
        this.code = code;
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public BaseException(int code , String msg){
        this.code = code;
        this.msg = msg;
    }

}
