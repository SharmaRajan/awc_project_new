package com.dalmia.crudapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class Opportunity {


    private long oporId;

    private String source;

    private Company companyName;

    private String opportunityScope;

    private Facility facilityName;


    private ContactPerson contactPerson;


//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="created_at")
    private Date createdAt;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="updated_at")
    private Date updatedAt;

//    @Column(name="created_by")
    private Long createdBy;

//    @Column(name="updated_by")
    private Long updatedBy;


}
