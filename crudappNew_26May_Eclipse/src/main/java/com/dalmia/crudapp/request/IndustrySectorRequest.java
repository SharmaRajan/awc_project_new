package com.dalmia.crudapp.request;

import com.dalmia.crudapp.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndustrySectorRequest {

    private long industryId;

    private String indName;

    private String description;

//    private Set<CompanyFormRequest> companies;

    private String approvedBy;

    private String status;

    private Calendar createdOn;

    private Calendar lastModified;

    private String createdBy;

    private String modifiedBy;

}
