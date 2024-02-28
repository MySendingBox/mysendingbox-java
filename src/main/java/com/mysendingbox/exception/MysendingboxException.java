package com.mysendingbox.exception;

public abstract class MysendingboxException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private Integer statusCode;

    public MysendingboxException(String message, Integer statusCode) {
        super(message, null);
        this.statusCode = statusCode;
    }

    public MysendingboxException(String message, Integer statusCode, Throwable e) {
        super(message, e);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

}
