package com.dalmia.dalmia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dalmia.dalmia.header.Header;
import com.dalmia.dalmia.request.dto.CompanyRequestDto;
import com.dalmia.dalmia.response.dto.CompanyResponseDto;
import com.dalmia.dalmia.responses.Response;
import com.dalmia.dalmia.service.CompanyServiceImpl;

import jakarta.validation.Valid;

@RestController
public class CompanyController {

	private CompanyServiceImpl service;
	
	@Autowired
	public CompanyController(CompanyServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/company")
	public Response<List<CompanyResponseDto>> getAllCompany() {
		return service.findAll();
	}
	
	@GetMapping("/company/{id}")
	public Response<CompanyResponseDto> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping("/company")
	public Response<CompanyResponseDto> saveCompany(@Valid @RequestBody CompanyRequestDto companyRequestDto) {
		return service.save(companyRequestDto);
	}
	
	@DeleteMapping("/company/{id}")
	public Header deleteCompany(@PathVariable int id) {
		return service.delete(id);
	}
	

}
