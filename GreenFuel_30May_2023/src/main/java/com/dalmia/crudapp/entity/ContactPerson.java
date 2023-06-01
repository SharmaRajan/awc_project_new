package com.dalmia.crudapp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "contact_person")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cont_pers_id")
    private long contPersId;

    @NotBlank(message = "Name can not be empty !!")
    @Column(name = "cont_pers_name")
    private String contPersName;

    @Column(name = "cont_pers_number")
    private int contPersNumber;

    @Column(name = "cont_pers_designation")
    private String contPersDesign;

    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "cont_pers_emailid")
    private String contPersEmailId;

    // A contact person has one facility
//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Facility.class)
    @JoinColumn(name = "fac_id")
    private Facility theFacility;

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

    public ContactPerson() {
    }

    public ContactPerson(long contPersId, String contPersName, int contPersNumber, String contPersDesign, String contPersEmailId, Facility theFacility) {
        this.contPersId = contPersId;
        this.contPersName = contPersName;
        this.contPersNumber = contPersNumber;
        this.contPersDesign = contPersDesign;
        this.contPersEmailId = contPersEmailId;
        this.theFacility = theFacility;
    }


    public ContactPerson(long contPersId, String contPersName, int contPersNumber, String contPersDesign, String contPersEmailId, Facility theFacility, String approvedBy, String status, Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
        this.contPersId = contPersId;
        this.contPersName = contPersName;
        this.contPersNumber = contPersNumber;
        this.contPersDesign = contPersDesign;
        this.contPersEmailId = contPersEmailId;
        this.theFacility = theFacility;
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

    public long getContPersId() {
        return contPersId;
    }

    public void setContPersId(long contPersId) {
        this.contPersId = contPersId;
    }

    public String getContPersName() {
        return contPersName;
    }

    public void setContPersName(String contPersName) {
        this.contPersName = contPersName;
    }

    public int getContPersNumber() {
        return contPersNumber;
    }

    public void setContPersNumber(int contPersNumber) {
        this.contPersNumber = contPersNumber;
    }

    public String getContPersDesign() {
        return contPersDesign;
    }

    public void setContPersDesign(String contPersDesign) {
        this.contPersDesign = contPersDesign;
    }

    public String getContPersEmailId() {
        return contPersEmailId;
    }

    public void setContPersEmailId(String contPersEmailId) {
        this.contPersEmailId = contPersEmailId;
    }

    public Facility getTheFacility() {
        return theFacility;
    }

    public void setTheFacility(Facility theFacility) {
        this.theFacility = theFacility;
    }
}
