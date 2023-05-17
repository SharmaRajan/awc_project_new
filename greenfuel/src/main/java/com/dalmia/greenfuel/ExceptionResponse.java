package com.dalmia.greenfuel;

import java.util.Date;

public class ExceptionResponse {

    private Integer responseCode;
//    private Date requestDate;
    private String url;
    private String errorMsg;

    public ExceptionResponse(Integer responseCode, String url, String errorMsg){
        super();
        this.responseCode = responseCode;
        this.url = url;
        this.errorMsg = errorMsg;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
