package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "target_dalmia_plant")
public class TargetDalmiaPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_id")
    private long plantId;

    @Column(name = "dalmia_plant_name")
    private String dalmiaPlantName;

    // a dalmia plant can have one facility
//    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fac_id")
    private Facility theDalmiaFacility;

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


    public TargetDalmiaPlant() {
    }

    public TargetDalmiaPlant(long plantId, String dalmiaPlantName, Facility theDalmiaFacility) {
        this.plantId = plantId;
        this.dalmiaPlantName = dalmiaPlantName;
        this.theDalmiaFacility = theDalmiaFacility;
    }

    public TargetDalmiaPlant(long plantId, String dalmiaPlantName, Facility theDalmiaFacility, String approvedBy, String status, Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
        this.plantId = plantId;
        this.dalmiaPlantName = dalmiaPlantName;
        this.theDalmiaFacility = theDalmiaFacility;
        this.approvedBy = approvedBy;
        this.status = status;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
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

    public long getPlantId() {
        return plantId;
    }

    public void setPlantId(long plantId) {
        this.plantId = plantId;
    }

    public String getDalmiaPlantName() {
        return dalmiaPlantName;
    }

    public void setDalmiaPlantName(String dalmiaPlantName) {
        this.dalmiaPlantName = dalmiaPlantName;
    }

    public Facility getTheDalmiaFacility() {
        return theDalmiaFacility;
    }

    public void setTheDalmiaFacility(Facility theDalmiaFacility) {
        this.theDalmiaFacility = theDalmiaFacility;
    }
}
