package com.dalmia.greenfuel.controller;

import com.dalmia.greenfuel.entity.Company;
import com.dalmia.greenfuel.exception.CompanyNotFoundException;
import com.dalmia.greenfuel.service.CompanyServiceImpl;
import com.dalmia.greenfuel.service.ICompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;


    @PostMapping(value = "/lists")//, headers = "Accept = application/json")
//@RequestMapping(value = "/lists",method = RequestMethod.POST)
//@ResponseBody
    public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company theCompany) throws CompanyNotFoundException{
        Company tempCompany = companyService.saveCompany(theCompany);
        return new ResponseEntity<>(tempCompany, HttpStatus.CREATED);
    }

    @GetMapping("/lists")
    public ResponseEntity<?> getAllCompany(){
        List<Company> companyList = companyService.getAllCompany();
        return new ResponseEntity<>(companyList,HttpStatus.OK);
    }

    @GetMapping("/lists/{id}")
    public ResponseEntity<?> getCompany(@PathVariable long id) throws CompanyNotFoundException {
        Company theCompany = companyService.getCompanyById(id);
        return new ResponseEntity<>(theCompany,HttpStatus.OK);
    }

    @GetMapping("/replica")
    public String replicaOfTable(String newTable){
        companyService.replica(newTable);
        return "created";

    }


}
