package com.dalmia.crudapp.response;

import com.dalmia.crudapp.entity.IndustrySector;

public class CompanyListResponse {

    private long id;
    private String companyName;

    private IndustrySectorResponse industrySector;

    private String presence;

    private long totalNoOfFacility;

    public CompanyListResponse() {
    }

    public CompanyListResponse(long id,String companyName, IndustrySectorResponse industrySector,
                               String presence, long totalNoOfFacility) {
        this.id = id;
        this.companyName = companyName;
        this.industrySector = industrySector;
        this.presence = presence;
        this.totalNoOfFacility = totalNoOfFacility;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public IndustrySectorResponse getIndustrySector() {
        return industrySector;
    }

    public void setIndustrySector(IndustrySectorResponse industrySector) {
        this.industrySector = industrySector;
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
}
