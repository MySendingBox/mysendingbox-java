package com.mysendingbox.exception;

public class AuthenticationException extends MysendingboxException {

    private static final long serialVersionUID = 1L;

    public AuthenticationException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
