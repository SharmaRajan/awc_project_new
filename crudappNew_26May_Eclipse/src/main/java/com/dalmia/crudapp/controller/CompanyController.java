package com.dalmia.crudapp.controller;

import com.dalmia.crudapp.entity.Company;
import com.dalmia.crudapp.exceptions.ValidationHandledException;
import com.dalmia.crudapp.request.CompanyFormRequest;
import com.dalmia.crudapp.response.CompanyListResponse;
import com.dalmia.crudapp.response.Response;
import com.dalmia.crudapp.service.ICompanyService;
import com.dalmia.crudapp.validation.CompanyFormValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private CompanyFormValidator companyValidator;

    // get all company lists
    @GetMapping("/lists")
    public ResponseEntity<?> companyList(HttpServletRequest request){
//        List<Company> companyList = companyService.getCompanyList(request);
        Response<CompanyListResponse> response = companyService.getCompanyList(request);

        return new ResponseEntity<Response>(response,HttpStatus.OK);
    }

    // get single company
    @GetMapping("/lists/{id}")
    public ResponseEntity<?> getCompany(@PathVariable Long id){
        Response<CompanyListResponse> tempCompanyResponse = companyService.findById(id);

        return new ResponseEntity<>(tempCompanyResponse,HttpStatus.OK);
    }

    // new company handler
//    @PostMapping("/lists")
    @RequestMapping(value = "/lists",method = RequestMethod.POST)
//    @ResponseBody
    public ResponseEntity<?> saveCompany(@RequestBody @Valid CompanyFormRequest companyFormRequest, BindingResult errors){

        companyValidator.validate(companyFormRequest,errors);
        if (errors.hasErrors()){
            throw new ValidationHandledException(HttpStatus.BAD_REQUEST,errors.getFieldErrors());
        }
        Response<String> response =companyService.saveCompany(companyFormRequest);
        return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
    }

    @PutMapping("/lists/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable long id){
        try{
            this.companyService.updateCompany(company,id);
            return ResponseEntity.ok().body(company);
        }catch (Exception exc){
            exc.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/lists/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){
        /*String deleteComp;

        Company tempCompany = companyService.findById(id);

        if(tempCompany == null){
            deleteComp = "ID does not exists";
        }else{
            companyService.deleteCompany(tempCompany.getId());
            deleteComp = "Company deleted with id: " + tempCompany.getId();
        }

        return new ResponseEntity<>(deleteComp, HttpStatus.OK);*/

        try{
            this.companyService.deleteCompany(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exc){
            exc.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
