package com.dalmia.greenfuel.advice;

import com.dalmia.greenfuel.ExceptionResponse;
import com.dalmia.greenfuel.exception.CompanyNotFoundException;

import com.dalmia.greenfuel.exception.HandledException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(CompanyNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
        return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandledException.class)
    public final ResponseEntity<ExceptionResponse> handleHandledException(HandledException ex, HttpServletRequest httpRequest) throws Exception {
        String message = ex.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getCode().value(),httpRequest.getRequestURI(),message);
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, ex.getCode());
    }

}
