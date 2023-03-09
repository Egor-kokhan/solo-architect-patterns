package com.otus.spaceBattle.exception;

public class OtusRuntimeException extends RuntimeException {

    public OtusRuntimeException() {
    }

    public OtusRuntimeException(String message) {
        super(message);
    }

    public OtusRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OtusRuntimeException(Throwable cause) {
        super(cause);
    }

    public OtusRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
