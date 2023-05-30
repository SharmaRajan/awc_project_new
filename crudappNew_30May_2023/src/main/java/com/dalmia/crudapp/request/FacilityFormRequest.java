package com.dalmia.crudapp.request;

import com.dalmia.crudapp.entity.Location;
import jakarta.validation.constraints.*;

import java.util.List;

/*@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor*/
public class FacilityFormRequest {

//    @NotNull(message = "facility name shouldn't be null")
    private String facilityName;

//    @NotNull(message = "company name shouldn't be null")
    private String companyName;

//    @NotNull(message = "industry sector shouldn't be null")
    private String industrySector;

//    @NotBlank
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

    @Email(message = "invalid email address")
    private String emailId;

    private String addContactDetails;

    public FacilityFormRequest() {}

    public FacilityFormRequest(String facilityName, String companyName, String industrySector,
                               String addressDetails, String addressLine2, int pinCode, String district,
                               String state, List<Location> geoLocation, String dalmiaActivePlants,
                               String typeOfWaste, String contactPersonName, String contactPersonNumber,
                               String contactPersonDesignation, String emailId, String addContactDetails) {
        this.facilityName = facilityName;
        this.companyName = companyName;
        this.industrySector = industrySector;
        this.addressDetails = addressDetails;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
        this.district = district;
        this.state = state;
        this.geoLocation = geoLocation;
        this.dalmiaActivePlants = dalmiaActivePlants;
        this.typeOfWaste = typeOfWaste;
        this.contactPersonName = contactPersonName;
        this.contactPersonNumber = contactPersonNumber;
        this.contactPersonDesignation = contactPersonDesignation;
        this.emailId = emailId;
        this.addContactDetails = addContactDetails;
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
