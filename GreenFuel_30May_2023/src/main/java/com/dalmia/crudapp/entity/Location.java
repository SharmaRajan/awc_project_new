package com.dalmia.crudapp.entity;

import jakarta.persistence.*;

//@Entity
//@Table(name = "location")//, uniqueConstraints = @UniqueConstraint(columnNames = { "theLocation" }))
public class Location {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "loc_id")
    private long locId;

//    @Column(name = "manual_address")
    private String manualAddress;

//    @Column(name = "current_location")
    private String currentLocation;

//    @Column(name="latitude")
    private String latitude;

//    @Column(name = "longitude")
    private String longitude;

    public Location() {}

    public Location(long locId, String manualAddress, String currentLocation, String latitude, String longitude) {
        this.locId = locId;
        this.manualAddress = manualAddress;
        this.currentLocation = currentLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(String manualAddress, String currentLocation, String latitude, String longitude) {
        this.manualAddress = manualAddress;
        this.currentLocation = currentLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getLocId() {
        return locId;
    }

    public void setLocId(long locId) {
        this.locId = locId;
    }

    public String getManualAddress() {
        return manualAddress;
    }

    public void setManualAddress(String manualAddress) {
        this.manualAddress = manualAddress;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
