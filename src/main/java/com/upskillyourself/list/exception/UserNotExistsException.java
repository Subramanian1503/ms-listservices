package com.upskillyourself.list.exception;

import com.upskillyourself.list.core.exception.TodoServiceException;

public class UserNotExistsException extends TodoServiceException {

    public UserNotExistsException(String errorCode) {
        super(errorCode);
    }

    public UserNotExistsException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

}
