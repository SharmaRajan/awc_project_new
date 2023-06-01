package com.dalmia.crudapp.response;

import java.util.HashMap;
import java.util.Map;

public class ValidateResponse {
	private Integer responseCode;
	private Map<String, String> errorMsg;
	private String responseDesc;

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public Map<String, String> geterrorMsg() {
		return errorMsg;
	}

	public void seterrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void seterrorMsg(HashMap<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public ValidateResponse(Integer responseCode, Map<String, String> errorMsg, String responseDesc) {
		super();
		this.responseCode = responseCode;
		this.errorMsg = errorMsg;
		this.responseDesc = responseDesc;
	}

	public ValidateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
