package com.dalmia.crudapp.request;

import com.dalmia.crudapp.entity.IndustrySector;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyFormRequest {

    @Pattern(regexp = "[A-Za-z0-9\\s.]*$",message = "company name starts with capital letter")
    @NotBlank(message = "Company name can't be empty")
    private String companyName;

    private long industrySector;

    @NotBlank(message = "Presence can't be empty")
    private String presence;

    private long totalNoOfFacility;

    @NotBlank(message = "status can't be empty")
    private String status;

    private String approvedBy;

    private String createdBy;

    private String modifiedBy;

    private Calendar createdOn;

    private Calendar lastModified;

    }
