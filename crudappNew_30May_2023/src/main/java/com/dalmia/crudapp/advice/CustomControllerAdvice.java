package com.dalmia.crudapp.advice;

import com.dalmia.crudapp.exceptions.HandledException;
import com.dalmia.crudapp.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HandledException.class)
    public final ResponseEntity<ExceptionResponse> handleHandledException(HandledException ex, HttpServletRequest httpRequest) throws Exception {
        String message = ex.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getCode().value(),new Date(),httpRequest.getRequestURI(),message,ex.getCode().name());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, ex.getCode());
    }

}
