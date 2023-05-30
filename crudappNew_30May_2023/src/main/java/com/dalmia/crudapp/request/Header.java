package com.dalmia.crudapp.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Header {

    private HttpStatus responseCode;

    private String message;

    public Header() {
        this.responseCode = HttpStatus.NO_CONTENT;
        this.message = "unknown";
    }

    public Header(HttpStatus responseCode, String message) {
        super();
        this.responseCode = responseCode;
        this.message = message;
    }
}
