package com.dalmia.crudapp.service;

import com.dalmia.crudapp.entity.Facility;
import com.dalmia.crudapp.request.FacilityFormRequest;
import com.dalmia.crudapp.response.FacilityListResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface IFacilityService {

    List<FacilityListResponse> getAllFacilities(HttpServletRequest request);

    Facility saveFacility(FacilityFormRequest request);

    Facility save(Facility facility);
}
