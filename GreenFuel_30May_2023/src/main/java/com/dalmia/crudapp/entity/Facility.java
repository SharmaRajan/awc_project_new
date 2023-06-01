package com.dalmia.crudapp.entity;

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

    @Column(name = "GEO_LATITUDE")
    private String geoLatitude;

    @Column(name = "GEO_LONGITUDE")
    private String geoLongitude;

    @Column(name="active_dalmia_plants")
    private long activeDalmiaPlants;


    // a facility can have multiple type of waste
//    @JsonBackReference
//    @ManyToMany(mappedBy = "facility",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    // 1st method
    @ManyToMany
    private Set<WasteType> waste;

    // 2nd method
//    @ManyToMany
//    @JoinTable(name = "facility_waste",joinColumns =
//            @JoinColumn(name = "fac_id"),inverseJoinColumns = @JoinColumn(name = "waste_id"))
//    private Set<WasteType> waste;


    // a facility can have multiple Dalmia plants
//    @JsonBackReference
    @OneToMany(mappedBy = "theDalmiaFacility",fetch = FetchType.LAZY)
    private Set<TargetDalmiaPlant> targetDalmiaPlant;


    // A facility has many contact persons
    @OneToMany(mappedBy = "theFacility",fetch = FetchType.LAZY)
    private Set<ContactPerson> persons;

    // A facility has one company
//    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Company.class)
    @JoinColumn(name = "comp_id",insertable = false, updatable = false)
    private Company theCompany;

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

    public Facility() {
    }

    public Facility(long facId, String facilityName, String addressDetails, String addressLine2, int pinCode, String district, String state, String geoLatitude, String geoLongitude, long activeDalmiaPlants, Set<WasteType> waste, Set<TargetDalmiaPlant> targetDalmiaPlant, Set<ContactPerson> persons, Company theCompany, String approvedBy, String status, Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
        this.facId = facId;
        this.facilityName = facilityName;
        this.addressDetails = addressDetails;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
        this.district = district;
        this.state = state;
        this.geoLatitude = geoLatitude;
        this.geoLongitude = geoLongitude;
        this.activeDalmiaPlants = activeDalmiaPlants;
        this.waste = waste;
        this.targetDalmiaPlant = targetDalmiaPlant;
        this.persons = persons;
        this.theCompany = theCompany;
        this.approvedBy = approvedBy;
        this.status = status;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public String getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLatitude(String geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    public String getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(String geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public Set<TargetDalmiaPlant> getTargetDalmiaPlant() {
        return targetDalmiaPlant;
    }

    public void setTargetDalmiaPlant(Set<TargetDalmiaPlant> targetDalmiaPlant) {
        this.targetDalmiaPlant = targetDalmiaPlant;
    }

    public Set<ContactPerson> getPersons() {
        return persons;
    }

    public void setPersons(Set<ContactPerson> persons) {
        this.persons = persons;
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

    public long getActiveDalmiaPlants() {
        return activeDalmiaPlants;
    }

    public void setActiveDalmiaPlants(long activeDalmiaPlants) {
        this.activeDalmiaPlants = activeDalmiaPlants;
    }

    public Set<WasteType> getWaste() {
        return waste;
    }

    public void setWaste(Set<WasteType> waste) {
        this.waste = waste;
    }

    public Company getTheCompany() {
        return theCompany;
    }

    public void setTheCompany(Company theCompany) {
        this.theCompany = theCompany;
    }
}
