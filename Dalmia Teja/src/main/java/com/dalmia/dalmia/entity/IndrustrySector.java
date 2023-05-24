package com.dalmia.dalmia.entity;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "indrustry_sector")
public class IndrustrySector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "indrustry_sector_id")
	private int sectorId;
	
	
	@Column(name = "sector")
	private String sector;
	
	@Column(name = "description")
	private String Description;
	
	@OneToMany(mappedBy = "sector")
	private Set<Company> company;
	
	
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
	
	
	public IndrustrySector() {
	}

	

	public IndrustrySector(String sector, String description, String approvedBy, String status) {
		super();
		this.sector = sector;
		Description = description;
		this.approvedBy = approvedBy;
		this.status = status;
	}


	public IndrustrySector(String sector, String description, String approvedBy, String status, Calendar createdOn,
			String createdBy) {
		super();
		this.sector = sector;
		Description = description;
		this.approvedBy = approvedBy;
		this.status = status;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public IndrustrySector(String sector, String description, String approvedBy, String status, Calendar createdOn,
			Calendar lastModified, String createdBy, String modifiedBy) {
		super();
		this.sector = sector;
		Description = description;
		this.approvedBy = approvedBy;
		this.status = status;
		this.createdOn = createdOn;
		this.lastModified = lastModified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}



	public int getIndrustrySectorid() {
		return sectorId;
	}


	public void setIndrustrySectorid(int indrustrySectorid) {
		this.sectorId = indrustrySectorid;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


//	public Set<Company> getCompany() {
//		return company;
//	}
//
//
//	public void setCompany(Set<Company> company) {
//		this.company = company;
//	}


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
