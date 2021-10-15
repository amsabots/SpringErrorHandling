package com.abcthebank.andrew.mwebbi.priviledgedroles.errorhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class ErrorControllerAdvisor {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorHandlerPojo> resourceNotFound(ResourceNotFoundException ex) {
        ErrorHandlerPojo errorHandlerPojo = new ErrorHandlerPojo();
        errorHandlerPojo.setErrorCode("ENOTFOUND");
        errorHandlerPojo.setDate(new Date());
        errorHandlerPojo.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorHandlerPojo, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorHandlerPojo> resourceNotFound(MissingServletRequestParameterException ex) {
        ErrorHandlerPojo errorHandlerPojo = new ErrorHandlerPojo();
        errorHandlerPojo.setErrorCode("EINVALIDREQUEST");
        errorHandlerPojo.setDate(new Date());
        errorHandlerPojo.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorHandlerPojo, HttpStatus.BAD_REQUEST);
    }
}
