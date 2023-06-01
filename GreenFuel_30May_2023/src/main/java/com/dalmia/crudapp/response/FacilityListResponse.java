package com.dalmia.crudapp.response;

import com.dalmia.crudapp.entity.Location;

import java.util.List;

public class FacilityListResponse {

    private Long facId;

    private String facilityName;

    private String companyName;

    private String industrySector;

    private String addressDetails;

    private String addressLine2;

    private int pinCode;

    private String district;

    private String state;

    private List<Location> geoLocation;

    private String dalmiaActivePlants;

    private String typeOfWaste;

    private String contactPersonName;

    private String contactPersonNumber;

    private String contactPersonDesignation;

    private String emailId;

    private String addContactDetails;

    public FacilityListResponse() {}



    public Long getFacId() {
        return facId;
    }

    public void setFacId(Long facId) {
        this.facId = facId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustrySector() {
        return industrySector;
    }

    public void setIndustrySector(String industrySector) {
        this.industrySector = industrySector;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Location> getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(List<Location> geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getDalmiaActivePlants() {
        return dalmiaActivePlants;
    }

    public void setDalmiaActivePlants(String dalmiaActivePlants) {
        this.dalmiaActivePlants = dalmiaActivePlants;
    }

    public String getTypeOfWaste() {
        return typeOfWaste;
    }

    public void setTypeOfWaste(String typeOfWaste) {
        this.typeOfWaste = typeOfWaste;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonNumber() {
        return contactPersonNumber;
    }

    public void setContactPersonNumber(String contactPersonNumber) {
        this.contactPersonNumber = contactPersonNumber;
    }

    public String getContactPersonDesignation() {
        return contactPersonDesignation;
    }

    public void setContactPersonDesignation(String contactPersonDesignation) {
        this.contactPersonDesignation = contactPersonDesignation;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddContactDetails() {
        return addContactDetails;
    }

    public void setAddContactDetails(String addContactDetails) {
        this.addContactDetails = addContactDetails;
    }
}
