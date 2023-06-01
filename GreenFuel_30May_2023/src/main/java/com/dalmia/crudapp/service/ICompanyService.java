package com.dalmia.crudapp.service;

import com.dalmia.crudapp.entity.Company;
import com.dalmia.crudapp.request.CompanyFormRequest;
import com.dalmia.crudapp.response.CompanyListResponse;
import com.dalmia.crudapp.response.Response;
import jakarta.servlet.http.HttpServletRequest;


public interface ICompanyService {

    Response<CompanyListResponse> findById(Long id);

//    List<Company> getCompanyList(HttpServletRequest request);

    Response<CompanyListResponse> getCompanyList(HttpServletRequest request);

    Response<String> saveCompany(CompanyFormRequest companyFormRequest);

    Company deleteCompany(Long id);

    void updateCompany(Company company, long id);

    Company save(Company tempCompany);
}
