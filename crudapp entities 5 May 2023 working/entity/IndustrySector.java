package com.dalmia.crudapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "industry_sector")
public class IndustrySector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ind_id")
    private long industryId;

    @Column(name = "ind_name")
    private String indName;

    @Column(name = "description")
    private String description;

    // an industry sector can have multiple companies
    @JsonBackReference
    @OneToMany(mappedBy = "theIndustrySector",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Company> companies;

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

    public IndustrySector() {
    }

    public IndustrySector(long industryId, String indName, List<Company> companies) {
        this.industryId = industryId;
        this.indName = indName;
        this.companies = companies;
    }

    public IndustrySector(long industryId, String indName, String description, List<Company> companies, String approvedBy, String status, Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
        this.industryId = industryId;
        this.indName = indName;
        this.description = description;
        this.companies = companies;
        this.approvedBy = approvedBy;
        this.status = status;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(long industryId) {
        this.industryId = industryId;
    }

    public String getIndName() {
        return indName;
    }

    public void setIndName(String indName) {
        this.indName = indName;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
