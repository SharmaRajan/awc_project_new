package com.dalmia.crudapp.serviceImpl;

import com.dalmia.crudapp.entity.Facility;
import com.dalmia.crudapp.helper.PageModel;
import com.dalmia.crudapp.repository.IFacilityRepo;
import com.dalmia.crudapp.request.FacilityFormRequest;
import com.dalmia.crudapp.response.FacilityListResponse;
import com.dalmia.crudapp.service.IFacilityService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private IFacilityRepo facilityRepo;

    @Override
    public List<FacilityListResponse> getAllFacilities(HttpServletRequest request) {

//        Page<Facility> facilityPageList = facilityRepo.findAll(PageRequest.of(PageModel.getPAGE(), PageModel.getSIZE()));

        /*List<FacilityListResponse> facilityListResponses = facilityPageList.getContent().stream().map(facility -> {
            return new FacilityListResponse(facility.getFacId(),facility.getFacilityName(),facility.getCompanyName(),facility.getIndustrySector(),
                    facility.getAddressDetails(), facility.getAddressLine2(),facility.getPinCode(),facility.getDistrict(),
                    facility.getState(),facility.getGeoLocation(),facility.getDalmiaActivePlants(),facility.getTypeOfWaste(),
                    facility.getContactPersonName(),facility.getContactPersonNumber(),facility.getContactPersonDesignation(),
                    facility.getEmailId(),facility.getAddContactDetails());
                })
                .collect(Collectors.toList());*/

//        return facilityListResponses;
        return null;
    }

    @Override
    public Facility saveFacility(FacilityFormRequest request) {

        BigInteger bigInteger = BigInteger.valueOf(0);

        /*Facility temp = Facility.build(bigInteger,request.getFacilityName(), request.getCompanyName(),
                request.getIndustrySector(), request.getAddressDetails(),
                request.getAddressLine2(), request.getPinCode(), request.getDistrict(),
                request.getState(), request.getGeoLocation(), request.getDalmiaActivePlants(), request.getTypeOfWaste(),
                request.getContactPersonName(), request.getContactPersonNumber(),
                request.getContactPersonDesignation(), request.getEmailId(), request.getAddContactDetails());*/

        /*Facility tempFacility = new Facility(request.getFacilityName(), request.getCompanyName(),
                request.getIndustrySector(), request.getAddressDetails(),
                request.getAddressLine2(), request.getPinCode(), request.getDistrict(),
                request.getState(), request.getGeoLocation(), request.getDalmiaActivePlants(), request.getTypeOfWaste(),
                request.getContactPersonName(), request.getContactPersonNumber(),
                request.getContactPersonDesignation(), request.getEmailId(),
                request.getAddContactDetails());

        return facilityRepo.save(tempFacility);*/
        return  null;
    }

    @Override
    public Facility save(Facility facility) {
        Facility temp = facilityRepo.save(facility);
        return temp;
    }
}
