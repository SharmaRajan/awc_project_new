package com.dalmia.crudapp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndustrySectorResponse {

    private long industryId;

    private String indName;

    private String description;

    private String approvedBy;

    private String status;

    private Calendar createdOn;

    private Calendar lastModified;

    private String createdBy;

    private String modifiedBy;


}
