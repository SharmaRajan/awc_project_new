package com.dalmia.crudapp.entity;

import com.dalmia.crudapp.helper.Presence;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="company")//, uniqueConstraints = @UniqueConstraint(columnNames = { "theCompany" }))
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comp_id")
    private long id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="industry_sector")
    private IndustrySector industrySector;

    @Enumerated(EnumType.STRING)
    @Column(name="presence")
    private Presence presence;

    @Column(name="total_no_of_facility")
    private long totalNoOfFacility;

    // A company has many facilities
    @OneToMany(mappedBy = "theCompany",cascade = CascadeType.ALL)
    private List<Facility> facilities;

    public Company(){}

    public Company(String companyName, IndustrySector industrySector, Presence presence, long totalNoOfFacility, List<Facility> facilities) {
        this.companyName = companyName;
        this.industrySector = industrySector;
        this.presence = presence;
        this.totalNoOfFacility = totalNoOfFacility;
        this.facilities = facilities;
    }

    public Company(long id, String companyName, IndustrySector industrySector, Presence presence, long totalNoOfFacility, List<Facility> facilities) {
        this.id = id;
        this.companyName = companyName;
        this.industrySector = industrySector;
        this.presence = presence;
        this.totalNoOfFacility = totalNoOfFacility;
        this.facilities = facilities;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public IndustrySector getIndustrySector() {
        return industrySector;
    }

    public void setIndustrySector(IndustrySector industrySector) {
        this.industrySector = industrySector;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public long getTotalNoOfFacility() {
        return totalNoOfFacility;
    }

    public void setTotalNoOfFacility(long totalNoOfFacility) {
        this.totalNoOfFacility = totalNoOfFacility;
    }

}
