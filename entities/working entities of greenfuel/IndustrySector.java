package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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

    @JsonBackReference
    @OneToMany(mappedBy = "theIndustrySector",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Company> companies;

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

    public IndustrySector() {
    }

    public IndustrySector(long industryId, String indName, List<Company> companies) {
        this.industryId = industryId;
        this.indName = indName;
        this.companies = companies;
    }

    public IndustrySector(long industryId, String indName, List<Company> companies, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy) {
        this.industryId = industryId;
        this.indName = indName;
        this.companies = companies;
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
