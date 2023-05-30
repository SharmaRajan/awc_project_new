package com.dalmia.crudapp.response;

import com.dalmia.crudapp.request.Header;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private Header header;

    public ErrorResponse() {
    }

    public ErrorResponse(Header header) {
        super();
        this.header = header;
    }
}
