package com.dalmia.crudapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationHandledException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private HttpStatus code;
    private List<FieldError> errors;

    private List<ObjectError> objErrors;

    private FieldError fieldError;

    public ValidationHandledException(HttpStatus code, List<FieldError> errors) {
        super();
        this.code = code;
        this.errors = errors;
    }

    public ValidationHandledException(HttpStatus code, FieldError errors) {
        super();
        this.code = code;
        this.fieldError= errors;
    }

    public List<ObjectError> getObjErrors() {
        return objErrors;
    }

    public void setObjErrors(List<ObjectError> objErrors) {
        this.objErrors = objErrors;
    }

    public FieldError getFieldError() {
        return fieldError;
    }

    public void setFieldError(FieldError fieldError) {
        this.fieldError = fieldError;
    }



    /*public ValidationHandledException(HttpStatus code, List<ObjectError> errors) {
        super();
        this.code = code;
        this.objErrors = errors;
    }*/

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }
}
