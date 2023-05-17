package com.dalmia.greenfuel.service;

import com.dalmia.greenfuel.entity.Company;
import com.dalmia.greenfuel.exception.CompanyNotFoundException;
import com.dalmia.greenfuel.exception.HandledException;
import com.dalmia.greenfuel.repo.ICompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepo companyRepo;

    @Override
    public Company saveCompany(Company theCompany) throws CompanyNotFoundException {


//        Optional<Company> tempCompanyOptional
        try {
            Company tempCompany = theCompany;
            if (theCompany != null) {
                if (theCompany.getCompanyName() == null || theCompany.getCompanyName().isEmpty()) { // || theCompany.getCompanyName() == ""
                    throw new CompanyNotFoundException("Company name can't be empty");
                }
                if (theCompany.getStatus().isEmpty()) {
                    throw new CompanyNotFoundException("Status can't be empty");
                }
                companyRepo.save(tempCompany);
                return tempCompany;
            } else {
                throw new CompanyNotFoundException("Empty company");
            }
        } catch (HandledException e) {
            throw new HandledException(e.getCode(), e.getMessage());
        }catch (Exception e) {
            throw new HandledException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public List<Company> getAllCompany() {
        List<Company> companyList = companyRepo.findAll();
        return companyList;
    }

    @Override
    public Company getCompanyById(long id) throws CompanyNotFoundException {

        return companyRepo.findById(id).orElseThrow(()->new CompanyNotFoundException("Company with id: " + id + " not found"));

        /*Optional<Company> optionalCompany = companyRepo.findById(id);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        return null;*/
    }

    @Override
    public void replica(String newTable) {
        companyRepo.replica();
    }
}
