package com.dalmia.crudapp.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

//@Entity
//@Table
public class Opportunity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "op_id")
    private long opId;

//    @Transient
    private String source;

    private String companyName;

    private String opportunityScope;

    private String facilityName;

//    private List<String>

    private Date createdOn;

    private String contactPerson;

    private String contactNumber;

    private String contactPersonDesignation;

    private String emailId;

    private String addressDetails;

    private String addressLine2;

    private int pinCode;

    private String district;

    private String state;

    private List<String> geoLocation;

    public Opportunity() {
    }

    public Opportunity(long opId, String source) {
        this.opId = opId;
        this.source = source;
    }

    public long getOpId() {
        return opId;
    }

    public void setOpId(long opId) {
        this.opId = opId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
