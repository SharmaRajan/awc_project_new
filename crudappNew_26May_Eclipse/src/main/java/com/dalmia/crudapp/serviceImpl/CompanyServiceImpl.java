package com.dalmia.crudapp.serviceImpl;

import com.dalmia.crudapp.entity.Company;
import com.dalmia.crudapp.entity.IndustrySector;
import com.dalmia.crudapp.exceptions.HandledException;
import com.dalmia.crudapp.helper.PageModel;
import com.dalmia.crudapp.repository.ICompanyRepo;
import com.dalmia.crudapp.repository.IIndustrySectorRepo;
import com.dalmia.crudapp.request.CompanyFormRequest;
import com.dalmia.crudapp.response.CompanyListResponse;
import com.dalmia.crudapp.response.IndustrySectorResponse;
import com.dalmia.crudapp.response.Response;
import com.dalmia.crudapp.service.ICompanyService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ICompanyRepo companyRepo;

    @Autowired
    private IIndustrySectorRepo industrySectorRepo;

    @Autowired
    private PageModel pageModel;

    @Override
    public Response<CompanyListResponse> findById(Long id) {

        Company tempCompany = companyRepo.findById(id)
                .orElseThrow(() ->new HandledException(HttpStatus.NOT_FOUND,"id: " + id + " not found"));

        Response<CompanyListResponse> response = new Response<>();
        String errorMsg = null;

        Long industrySectorId = tempCompany.getTheIndustrySector();

        IndustrySector tempIndustry = industrySectorRepo.findById(industrySectorId)
                .orElseThrow(() -> new HandledException(HttpStatus.NOT_FOUND,"id: " + industrySectorId + " not found"));

        IndustrySectorResponse industrySectorResponse = modelMapper.map(tempIndustry,IndustrySectorResponse.class);

        CompanyListResponse companyResponse =   new CompanyListResponse(tempCompany.getCompId(), tempCompany.getCompanyName(),
                industrySectorResponse,tempCompany.getPresence(),tempCompany.getTotalNoOfFacility(),tempCompany.getApprovedBy(),
                tempCompany.getCreatedBy(),tempCompany.getModifiedBy(),tempCompany.getCreatedOn(),tempCompany.getLastModified());

        List<CompanyListResponse> companyListResponse  = new ArrayList<>();
        companyListResponse.add(companyResponse);

        response.setWrapperList(companyListResponse);

        response.setErrorMsg(errorMsg);
        response.setTotalcount(Long.valueOf(companyListResponse.size()));
        response.setResponseCode(String.valueOf(HttpStatus.OK.value()));
        response.setResponseDesc(HttpStatus.OK.name());

        return response;
    }

    @Override
    //public List<Company> getCompanyList(HttpServletRequest request) {
    public Response<CompanyListResponse> getCompanyList(HttpServletRequest request) {

        Response<CompanyListResponse> response = new Response<CompanyListResponse>();
        PageModel.setSIZE(20);
        pageModel.initPageAndSize();

        Page<Company> companyPageList = companyRepo.findAll(PageRequest.of(PageModel.getPAGE(), PageModel.getSIZE()));

        long totalCount = companyPageList.getTotalElements();
        String errorMsg = null;

        List<CompanyListResponse> companyListResponse = companyPageList.getContent().stream()
                .map(comp-> {

                   Long industrySectorId = comp.getTheIndustrySector();

                    IndustrySector tempIndustry = industrySectorRepo.findById(industrySectorId)
                            .orElseThrow(() -> new HandledException(HttpStatus.NOT_FOUND,"id: " + industrySectorId + " not found"));

                    IndustrySectorResponse industrySectorResponse = modelMapper.map(tempIndustry,IndustrySectorResponse.class);

                    return new CompanyListResponse(comp.getCompId(), comp.getCompanyName(),
                            industrySectorResponse,comp.getPresence(),comp.getTotalNoOfFacility(),comp.getApprovedBy(),
                            comp.getCreatedBy(),comp.getModifiedBy(),comp.getCreatedOn(),comp.getLastModified());
        }).collect(Collectors.toList());

        response.setWrapperList(companyListResponse);

        response.setTotalcount(totalCount);
        response.setErrorMsg(errorMsg);
        response.setResponseCode(String.valueOf(HttpStatus.OK.value()));
        response.setResponseDesc(HttpStatus.OK.name());

        return response;
    }

    @Override
    @Transactional
    public Response<String> saveCompany(CompanyFormRequest companyFormRequest) {
        Response<String> response =new Response<>();

        Optional<Company> optionalCompany =companyRepo.findByName(companyFormRequest.getCompanyName());
        try {
            if (!optionalCompany.isPresent()) {
                Company newCompany = new Company();
                newCompany.setCompanyName(companyFormRequest.getCompanyName());

//                IndustrySector industrySector = modelMapper.map(companyFormRequest.getIndustrySector(),IndustrySector.class);

                Long indId = companyFormRequest.getIndustrySector();

                Optional<IndustrySector> industrySectorOptional = industrySectorRepo.findById(indId);

                if(industrySectorOptional.isPresent()){
                    newCompany.setTheIndustrySector(companyFormRequest.getIndustrySector());
                }else{
                    throw new HandledException(HttpStatus.NOT_FOUND,"Industry Sector id: " + indId + " not found");
                }

                newCompany.setPresence(companyFormRequest.getPresence());
                newCompany.setTotalNoOfFacility(companyFormRequest.getTotalNoOfFacility());
                newCompany.setApprovedBy(companyFormRequest.getApprovedBy());
                newCompany.setCreatedBy(companyFormRequest.getCreatedBy());
                newCompany.setModifiedBy(companyFormRequest.getModifiedBy());
                newCompany.setLastModified(companyFormRequest.getLastModified());
                newCompany.setCreatedOn(companyFormRequest.getCreatedOn());

                Company savedNewCompany = companyRepo.save(newCompany);
//                response.setWrapperList((List<String>) savedNewCompany);
                response.setResponseCode(String.valueOf(HttpStatus.OK.value()));
                response.setResponseDesc(HttpStatus.OK.name());
                return response;
            } else {
                throw new HandledException(HttpStatus.UNPROCESSABLE_ENTITY, "Company Already exist with this name");
            }
        }catch (HandledException e) {
            throw new HandledException(e.getCode(), e.getMessage());
        } catch (Exception e) {
            throw new HandledException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public Company deleteCompany(Long id) {

        Optional<Company> optionalCompany = companyRepo.findById(id);

        if(optionalCompany.isPresent()){
            Company tempCompany = optionalCompany.get();
            companyRepo.delete(tempCompany);
            return tempCompany;
        }
        return null;
    }

    @Override
    public void updateCompany(Company company, long id) {
        company.setCompId(id);
        companyRepo.save(company);
    }

    @Override
    public Company save(Company tempCompany) {
        Company temp = companyRepo.save(tempCompany);
        return temp;
    }
}
