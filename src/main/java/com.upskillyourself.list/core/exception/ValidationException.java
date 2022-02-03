package com.upskillyourself.list.core.exception;

public class ValidationException extends TodoServiceException{

    public ValidationException(String errorCode) {
        super(errorCode);
    }

    public ValidationException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ValidationException(String errorCode, String errorMessage, Throwable throwable) {
        super(errorCode, errorMessage, throwable);
    }
}
