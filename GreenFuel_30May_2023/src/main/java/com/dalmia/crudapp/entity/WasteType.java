package com.dalmia.crudapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "waste")
public class WasteType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waste_id")
    private long wasteId;

    @Column(name = "waste_name")
    private String wasteName;

    @Column(name = "remarks")
    private String remarks;

    // A particular waste is originated from that single facility

//    @JsonManagedReference
//    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Facility.class)
//    @JoinColumn(name = "fac_id")

    // 1st method
    @ManyToMany(mappedBy = "waste",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Facility> facility;

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


    public WasteType() {
    }

    public WasteType(long wasteId, String wasteName, Set<Facility> facility) {
        this.wasteId = wasteId;
        this.wasteName = wasteName;
        this.facility = facility;
    }


    public WasteType(long wasteId, String wasteName, String remarks, Set<Facility> facility, String approvedBy, String status, Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
        this.wasteId = wasteId;
        this.wasteName = wasteName;
        this.remarks = remarks;
        this.facility = facility;
        this.approvedBy = approvedBy;
        this.status = status;
        this.createdOn = createdOn;
        this.lastModified = lastModified;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public long getWasteId() {
        return wasteId;
    }

    public void setWasteId(long wasteId) {
        this.wasteId = wasteId;
    }

    public String getWasteName() {
        return wasteName;
    }

    public void setWasteName(String wasteName) {
        this.wasteName = wasteName;
    }

    public Set<Facility> getFacility() {
        return facility;
    }

    public void setFacility(Set<Facility> facility) {
        this.facility = facility;
    }
}
