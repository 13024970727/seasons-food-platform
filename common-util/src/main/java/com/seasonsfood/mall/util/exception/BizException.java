package com.seasonsfood.mall.util.exception;

import com.seasonsfood.mall.util.constant.ResponseCode;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -4319552887844403472L;


    private ResponseCode responseCode;



    public BizException(ResponseCode responseCode, Object... args) {
        super(String.format(responseCode.getDesc(), args));
        this.responseCode = responseCode;
    }

    public BizException() {
        super();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(null, msgFormat, args);
    }

}
