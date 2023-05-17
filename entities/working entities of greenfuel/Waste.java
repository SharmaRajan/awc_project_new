package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "waste")
public class Waste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waste_id")
    private long wasteId;

    @Column(name = "waste_name")
    private String wasteName;


    // A particular waste is originated from that single facility
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Facility.class)
    @JoinColumn(name = "fac_id")
    private Facility facility;

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


    public Waste() {
    }

    public Waste(long wasteId, String wasteName, Facility facility) {
        this.wasteId = wasteId;
        this.wasteName = wasteName;
        this.facility = facility;
    }

    public Waste(long wasteId, String wasteName, Facility facility, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy) {
        this.wasteId = wasteId;
        this.wasteName = wasteName;
        this.facility = facility;
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

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
