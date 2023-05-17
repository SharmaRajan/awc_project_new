package com.dalmia.greenfuel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fac_id")
    private Facility theDalmiaFacility;

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


    public TargetDalmiaPlant() {
    }

    public TargetDalmiaPlant(long plantId, String dalmiaPlantName, Facility theDalmiaFacility, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy) {
        this.plantId = plantId;
        this.dalmiaPlantName = dalmiaPlantName;
        this.theDalmiaFacility = theDalmiaFacility;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public TargetDalmiaPlant(long plantId, String dalmiaPlantName, Facility theDalmiaFacility) {
        this.plantId = plantId;
        this.dalmiaPlantName = dalmiaPlantName;
        this.theDalmiaFacility = theDalmiaFacility;
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
