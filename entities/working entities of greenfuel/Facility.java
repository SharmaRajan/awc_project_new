package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facility")
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
    private String geoLocation;

    @Column(name="active_dalmia_plants")
    private long activeDalmiaPlants;


    // a facility can have multiple type of waste
    @JsonBackReference
    @OneToMany(mappedBy = "facility",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Waste> waste;

    // a facility can have multiple Dalmia plants
    @JsonBackReference
    @OneToMany(mappedBy = "theDalmiaFacility",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TargetDalmiaPlant> targetDalmiaPlant;


    // A facility has many contact persons
    @OneToMany(mappedBy = "theFacility",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ContactPerson> persons;

    // A facility has one company
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    @JoinColumn(name = "comp_id",insertable = false, updatable = false)
    private Company theCompany;

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

    public Facility() {
    }

    public Facility(long facId, String facilityName, String addressDetails, String addressLine2, int pinCode, String district, String state, String geoLocation, long activeDalmiaPlants, List<Waste> waste, List<TargetDalmiaPlant> targetDalmiaPlant, List<ContactPerson> persons, Company theCompany) {
        this.facId = facId;
        this.facilityName = facilityName;
        this.addressDetails = addressDetails;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
        this.district = district;
        this.state = state;
        this.geoLocation = geoLocation;
        this.activeDalmiaPlants = activeDalmiaPlants;
        this.waste = waste;
        this.targetDalmiaPlant = targetDalmiaPlant;
        this.persons = persons;
        this.theCompany = theCompany;
    }

    public Facility(long facId, String facilityName, String addressDetails, String addressLine2, int pinCode, String district, String state, String geoLocation, long activeDalmiaPlants, List<Waste> waste, List<TargetDalmiaPlant> targetDalmiaPlant, List<ContactPerson> persons, Company theCompany, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy) {
        this.facId = facId;
        this.facilityName = facilityName;
        this.addressDetails = addressDetails;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
        this.district = district;
        this.state = state;
        this.geoLocation = geoLocation;
        this.activeDalmiaPlants = activeDalmiaPlants;
        this.waste = waste;
        this.targetDalmiaPlant = targetDalmiaPlant;
        this.persons = persons;
        this.theCompany = theCompany;
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

    public long getFacId() {
        return facId;
    }

    public void setFacId(long facId) {
        this.facId = facId;
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

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public long getActiveDalmiaPlants() {
        return activeDalmiaPlants;
    }

    public void setActiveDalmiaPlants(long activeDalmiaPlants) {
        this.activeDalmiaPlants = activeDalmiaPlants;
    }

    public List<Waste> getWaste() {
        return waste;
    }

    public void setWaste(List<Waste> waste) {
        this.waste = waste;
    }

    public List<TargetDalmiaPlant> getTargetDalmiaPlant() {
        return targetDalmiaPlant;
    }

    public void setTargetDalmiaPlant(List<TargetDalmiaPlant> targetDalmiaPlant) {
        this.targetDalmiaPlant = targetDalmiaPlant;
    }

    public List<ContactPerson> getPersons() {
        return persons;
    }

    public void setPersons(List<ContactPerson> persons) {
        this.persons = persons;
    }

    public Company getTheCompany() {
        return theCompany;
    }

    public void setTheCompany(Company theCompany) {
        this.theCompany = theCompany;
    }
}
