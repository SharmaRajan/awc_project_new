package com.dalmia.dalmia.entity;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "dalmia_plant")
public class TargetPlant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dalmia_plant_id")
	private int dalmiaPlantId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	

	@Column(name = "approved_by")
	private String approvedBy;
	
	@Column(name = "status")
	private String status;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Calendar createdOn;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified")
	private Calendar lastModified;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "modified_by")
	private String modifiedBy;	
	
	
	
	public TargetPlant() {
	}



	public TargetPlant(String name, String description, String approvedBy, String status, Calendar createdOn,
			Calendar lastModified, String createdBy, String modifiedBy) {
		super();
		this.name = name;
		this.description = description;
		this.approvedBy = approvedBy;
		this.status = status;
		this.createdOn = createdOn;
		this.lastModified = lastModified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}



	public int getDalmiaPlantId() {
		return dalmiaPlantId;
	}



	public void setDalmiaPlantId(int dalmiaPlantId) {
		this.dalmiaPlantId = dalmiaPlantId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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


	
	
	
}
