package com.upskillyourself.list.core.errorhandler;

import com.upskillyourself.list.core.exception.TodoServiceException;
import com.upskillyourself.list.core.exception.ValidationException;
import com.upskillyourself.list.core.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorProcessor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ValidationException.class, TodoServiceException.class})
    public final ResponseEntity<Object> handleInternalException(Exception exception, WebRequest request) {
        if (exception instanceof ValidationException) {
            ValidationException validationException = (ValidationException) exception;
            return new ResponseEntity<>(new ErrorModel(validationException.getErrorCode(), validationException.getMessage(), LocalDateTime.now())
                    , HttpStatus.BAD_REQUEST);
        } else if (exception instanceof TodoServiceException) {
            TodoServiceException todoServiceException = (TodoServiceException) exception;
            return new ResponseEntity<>(new ErrorModel(todoServiceException.getErrorCode(), todoServiceException.getMessage(), LocalDateTime.now())
                    , HttpStatus.CONFLICT);
        } else
            return new ResponseEntity<>(new ErrorModel("TODOUSR000", exception.getMessage(), LocalDateTime.now())
                    , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
