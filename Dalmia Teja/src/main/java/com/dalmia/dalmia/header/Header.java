package com.dalmia.dalmia.header;

import org.springframework.http.HttpStatus;

public class Header {

	private HttpStatus responseCode;
	private String message;

	public Header() {
		this.responseCode = HttpStatus.NO_CONTENT;
		this.message = "unkown";

	}

	public Header(HttpStatus responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
