package com.dalmia.greenfuel.service;

import com.dalmia.greenfuel.entity.Company;
import com.dalmia.greenfuel.exception.CompanyNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICompanyService {

    Company saveCompany(Company theCompany) throws CompanyNotFoundException;

    List<Company> getAllCompany();

    Company getCompanyById(long id) throws CompanyNotFoundException;

    void replica(String newTable);
}
