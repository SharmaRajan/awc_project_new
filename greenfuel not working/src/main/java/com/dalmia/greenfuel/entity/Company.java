package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comp_id")
    private long compId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="presence")
    private String presence;

    @Column(name="total_no_of_facility")
    private long totalNoOfFacility;

    // A company has many facilities
    @JsonBackReference
    @OneToMany(mappedBy = "theCompany"
            ,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Facility> facilities;

    // A compnay originate from that particular industry sector
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IndustrySector.class)
    @JoinColumn(name = "ind_id") // add primary key of industry sector to map it here
    private IndustrySector theIndustrySector;

    @Column(name = "APPROVED_BY")
    private String approvedBy;

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

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    public Company() {
    }

    public Company(long compId, String companyName, String presence, long totalNoOfFacility, Set<Facility> facilities, IndustrySector theIndustrySector) {
        this.compId = compId;
        this.companyName = companyName;
        this.presence = presence;
        this.totalNoOfFacility = totalNoOfFacility;
        this.facilities = facilities;
        this.theIndustrySector = theIndustrySector;
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
}
