package com.seasonsfood.mall.util.exception;

/**
 * @author ron
 */
public class AssertFailException extends RuntimeException {
    public AssertFailException() {
        super();
    }

    public AssertFailException(String message) {
        super(message);
    }

    public AssertFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
