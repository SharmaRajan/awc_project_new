package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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
    private List<Facility> facilities;

//    @Column(name="industry_sector")
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IndustrySector.class)
    @JoinColumn(name = "ind_id")
    private IndustrySector theIndustrySector;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="created_by")
    private Long createdBy;

    @Column(name="updated_by")
    private Long updatedBy;

    public Company() {
    }

    public Company(long compId, String companyName, String presence, long totalNoOfFacility, List<Facility> facilities, IndustrySector theIndustrySector) {
        this.compId = compId;
        this.companyName = companyName;
        this.presence = presence;
        this.totalNoOfFacility = totalNoOfFacility;
        this.facilities = facilities;
        this.theIndustrySector = theIndustrySector;
    }

    public Company(long compId, String companyName, String presence, long totalNoOfFacility, List<Facility> facilities, IndustrySector theIndustrySector, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy) {
        this.compId = compId;
        this.companyName = companyName;
        this.presence = presence;
        this.totalNoOfFacility = totalNoOfFacility;
        this.facilities = facilities;
        this.theIndustrySector = theIndustrySector;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
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

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public IndustrySector getTheIndustrySector() {
        return theIndustrySector;
    }

    public void setTheIndustrySector(IndustrySector theIndustrySector) {
        this.theIndustrySector = theIndustrySector;
    }
}
