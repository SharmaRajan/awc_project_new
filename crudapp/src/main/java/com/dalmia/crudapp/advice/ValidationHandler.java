package com.dalmia.crudapp.advice;

import com.dalmia.crudapp.exceptions.ValidationHandledException;
import com.dalmia.crudapp.response.ValidateResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ValidateResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Map<String, String> messages = new HashMap<>(constraintViolations.size());
        messages.putAll(constraintViolations.stream()
                .collect(Collectors.toMap(
                        constraintViolation -> String.format("%s", constraintViolation.getPropertyPath()),
                        constraintViolation -> String.format("%s %s", constraintViolation.getPropertyPath(),
                                constraintViolation.getMessage()))));
        ValidateResponse validationResponse = new ValidateResponse(HttpStatus.BAD_REQUEST.value(), messages,
                HttpStatus.NOT_ACCEPTABLE.name());
        return new ResponseEntity<ValidateResponse>(validationResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationHandledException.class)
    public final ResponseEntity<ValidateResponse> handleHandledException(ValidationHandledException ex) throws Exception {
        List<FieldError> errs = ex.getErrors();
        Map<String, String> messages = new HashMap<>(errs.size());
        for (FieldError fieldError : errs) {
//			if (fieldError.getDefaultMessage() != null) {
            messages.put(fieldError.getField(), fieldError.getDefaultMessage());
//			}
        }
        ValidateResponse validationResponse = new ValidateResponse(HttpStatus.BAD_REQUEST.value(), messages,
                HttpStatus.NOT_ACCEPTABLE.name());
        return new ResponseEntity<ValidateResponse>(validationResponse, HttpStatus.BAD_REQUEST);
    }

}
