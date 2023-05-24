package com.dalmia.dalmia.exception;

import org.springframework.http.HttpStatus;

import com.dalmia.dalmia.header.Header;

public class IndrustrySectorNotFound extends RuntimeException{
	
	private HttpStatus code;
	Header header = new Header();

	public IndrustrySectorNotFound() {
		super("no message");
		this.code = HttpStatus.BAD_REQUEST;
	}

	public IndrustrySectorNotFound(Header header) {
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
