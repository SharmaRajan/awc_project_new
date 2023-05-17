package com.dalmia.greenfuel.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Facility.class)
    @JoinColumn(name = "fac_id")
    private Facility theFacility;

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

    public ContactPerson(long contPersId, String contPersName, int contPersNumber, String contPersDesign, String contPersEmailId, Facility theFacility, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy) {
        this.contPersId = contPersId;
        this.contPersName = contPersName;
        this.contPersNumber = contPersNumber;
        this.contPersDesign = contPersDesign;
        this.contPersEmailId = contPersEmailId;
        this.theFacility = theFacility;
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
