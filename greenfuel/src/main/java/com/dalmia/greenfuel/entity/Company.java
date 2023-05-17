package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.util.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comp_id")
    private long compId;

//    @Nonnull
    @Pattern(regexp = "[A-Za-z0-9\\s.]*$",message = "company name starts with capital letter")
    @NotBlank(message = "Company name can't be empty")
//    @Pattern(regexp = "^[a-zA-Z0-9\\s.\\p{Punct}]+$",message = "Company name start with Capital letter")
    @Column(name="company_name")
    private String companyName;

    @NotBlank(message = "Presence can't be empty")
    @Column(name="presence")
    private String presence;

    @Column(name="total_no_of_facility")
    private long totalNoOfFacility;

    // A company has many facilities
//    @JsonBackReference
    @OneToMany(mappedBy = "theCompany"
            ,cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Facility> facilities = new HashSet<>();

    // a company originate from single industry sector
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = IndustrySector.class)
    @JoinColumn(name = "ind_id") // add primary key of industry sector to map it here
    private IndustrySector theIndustrySector;

    @Column(name = "APPROVED_BY")
    private String approvedBy;

    @NotBlank(message = "status can't be empty")
    @Column(name = "STATUS")
    private String status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON")
    private Calendar createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED")
    private Calendar lastModified;

    @UpdateTimestamp
    @Temporal(TemporalType.TIME)
    @Column(name = "test_temporal")
    private Time testTemporal;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    public Company() {
    }

    public Company(long compId, String companyName, String presence, long totalNoOfFacility, Set<Facility> facilities, IndustrySector theIndustrySector, String approvedBy, String status, Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
        this.compId = compId;
        this.companyName = companyName;
        this.presence = presence;
        this.totalNoOfFacility = totalNoOfFacility;
        this.facilities = facilities;
        this.theIndustrySector = theIndustrySector;
        this.approvedBy = approvedBy;
        this.status = status;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public Time getTestTemporal() {
        return testTemporal;
    }

    public void setTestTemporal(Time testTemporal) {
        this.testTemporal = testTemporal;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public Calendar getLastModified() {
        return lastModified;
    }

    public void setLastModified(Calendar lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public long getCompId() {
        return compId;
    }

    public void setCompId(long compId) {
        this.compId = compId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public long getTotalNoOfFacility() {
        return totalNoOfFacility;
    }

    public void setTotalNoOfFacility(long totalNoOfFacility) {
        this.totalNoOfFacility = totalNoOfFacility;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }

    public IndustrySector getTheIndustrySector() {
        return theIndustrySector;
    }

    public void setTheIndustrySector(IndustrySector theIndustrySector) {
        this.theIndustrySector = theIndustrySector;
    }



}
