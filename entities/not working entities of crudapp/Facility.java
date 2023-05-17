package com.dalmia.crudapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "facility")//, uniqueConstraints = @UniqueConstraint(columnNames = { "theFacility" }))
//@Data
//@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fac_id")
    private long facId;

    @Column(name="facility_name")
    private String facilityName;

    @Column(name="address_details")
    private String addressDetails;

    @Column(name="address_line2")
    private String addressLine2;

    @Column(name="pin_code")
    private int pinCode;

    @Column(name="district")
    private String district;

    @Column(name="state")
    private String state;

    @Column(name="geo_location")
    private Location geoLocation;

    @Column(name="active_dalmia_plants")
    private long activeDalmiaPlants;

//    @Column(name="type_of_waste")
//    private String typeOfWaste;


    // A facility has many contact persons
    @OneToMany(mappedBy = "theFacility",cascade = CascadeType.ALL)
    private List<ContactPerson> persons;

    // A facility has one company
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_id",insertable = false, updatable = false)
    private Company theCompany;


    public Facility(){}

    public Facility(long facId, String facilityName, String addressDetails, String addressLine2, int pinCode, String district, String state, Location geoLocation, long activeDalmiaPlants, List<ContactPerson> persons, Company theCompany) {
        this.facId = facId;
        this.facilityName = facilityName;
        this.addressDetails = addressDetails;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
        this.district = district;
        this.state = state;
        this.geoLocation = geoLocation;
        this.activeDalmiaPlants = activeDalmiaPlants;
        this.persons = persons;
        this.theCompany = theCompany;
    }

    public List<ContactPerson> getPersons() {
        return persons;
    }

    public void setPersons(List<ContactPerson> persons) {
        this.persons = persons;
    }

    public long getFacId() {
        return facId;
    }

    public Location getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(Location geoLocation) {
        this.geoLocation = geoLocation;
    }

    public long getActiveDalmiaPlants() {
        return activeDalmiaPlants;
    }

    public void setActiveDalmiaPlants(long activeDalmiaPlants) {
        this.activeDalmiaPlants = activeDalmiaPlants;
    }


    public void setFacId(long facId) {
        this.facId = facId;
    }

    public Company getTheCompany() {
        return theCompany;
    }

    public void setTheCompany(Company theCompany) {
        this.theCompany = theCompany;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
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

}
