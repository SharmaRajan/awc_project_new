package com.dalmia.dalmia.responses;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.dalmia.dalmia.header.Header;

public class Response<T> {

	private Header header;
	private T data;

	public Response(Header header, T data) {
		super();
		this.header = header;
		this.data = data;
	}

	
	
	public Response(Header header,HttpStatus code) {
		super();
		this.header = header;
		this.header.setResponseCode(code);
	}



	public Response() {
	}


	public Response( T data) {
		super();
//		this.header = header;
		this.data = data;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
