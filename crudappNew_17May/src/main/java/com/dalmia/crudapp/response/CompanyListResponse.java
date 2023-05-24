package com.dalmia.crudapp.response;

import com.dalmia.crudapp.entity.IndustrySector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyListResponse {

    private long id;
    private String companyName;

    private IndustrySectorResponse industrySector;

    private String presence;

    private long totalNoOfFacility;

    private String approvedBy;

    private String createdBy;

    private String modifiedBy;

    private Calendar createdOn;

    private Calendar lastModified;



}
