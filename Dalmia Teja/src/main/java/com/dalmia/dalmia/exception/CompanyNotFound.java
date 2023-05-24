package com.dalmia.dalmia.exception;

import org.springframework.http.HttpStatus;

import com.dalmia.dalmia.header.Header;

public class CompanyNotFound extends RuntimeException {

	private HttpStatus code;
	Header header = new Header();

	public CompanyNotFound() {
		super("no message");
		this.code = HttpStatus.BAD_REQUEST;
	}

	public CompanyNotFound(Header header) {
		super(header.getMessage());
		this.header = header;
		
	}
	

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	
}
