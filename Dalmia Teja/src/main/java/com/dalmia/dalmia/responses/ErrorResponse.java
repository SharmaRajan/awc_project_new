package com.dalmia.dalmia.responses;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.dalmia.dalmia.header.Header;

public class ErrorResponse {

	private Header header;

	public ErrorResponse() {
	}

//	public ErrorResponse(Map<String , String> tempMap) {
//		Map<String , String > error = tempMap;
//	}
	
	public ErrorResponse(Header header) {
		super();
		this.header = header;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

}
