package com.dalmia.dalmia.service;

import java.util.List;

import com.dalmia.dalmia.header.Header;
import com.dalmia.dalmia.request.dto.CompanyRequestDto;
import com.dalmia.dalmia.response.dto.CompanyResponseDto;
import com.dalmia.dalmia.responses.Response;

public interface CompanyServiceLayor {
	
	public Response<List<CompanyResponseDto>> findAll();
	public Response<CompanyResponseDto> findById(int id);
	public Response<CompanyResponseDto> save(CompanyRequestDto companyRequestDto);
	public Header delete(int id);

}
