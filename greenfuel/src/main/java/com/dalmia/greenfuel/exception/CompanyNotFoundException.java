package com.dalmia.greenfuel.exception;

import com.dalmia.greenfuel.entity.Company;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

public class CompanyNotFoundException extends Exception {

    private String message;

    public CompanyNotFoundException(String message){
        super(message);
        this.message = message;
    }


    /*public CompanyNotFoundException(BindingResult bindingResult, String message) {
        super(bindingResult);
        this.message = message;
    }

    public CompanyNotFoundException(Object target, String objectName, String message) {
        super(target, objectName);
        this.message = message;
    }

    public CompanyNotFoundException(BindingResult bindingResult) {
        super(bindingResult);
    }*/

//    public CompanyNotFoundException(String message) {
////            super();
//        super(message);
//        this.message = message;
//    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
