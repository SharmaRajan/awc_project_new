package com.dalmia.dalmia.entity;

import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private int companyId;

	@Column(name = "company_name")
	private String companyName;

	@ManyToOne
	@JoinColumn(name = "indrustry_sector_id", referencedColumnName = "indrustry_sector_id")
	private IndrustrySector sector;

	@Column(name = "presence")
	private String presence;

	@Column(name = "total_number_of_facility")
	private int totalNumberOfFacility;

	@OneToMany(mappedBy = "company")
	@Column(name = "facility_id")
	private List<Facility> facility;

	@CreationTimestamp
	@Temporal(TemporalType.TIME)
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

	public Company() {
	}

//	public Company(String companyName, IndrustrySector sector, String presence, int totalNumberOfFacility,
//			String createdBy) {
//		super();
//		this.companyName = companyName;
//		this.presence = presence;
//		this.totalNumberOfFacility = totalNumberOfFacility;
//		this.createdBy = createdBy;
//	}
//	
//	public Company(String companyName, IndrustrySector sector, String presence, int totalNumberOfFacility,
//			List<Facility> facility, Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
//		super();
//		this.companyName = companyName;
//		this.sector = sector;
//		this.presence = presence;
//		this.totalNumberOfFacility = totalNumberOfFacility;
//		this.facility = facility;
//		this.createdOn = createdOn;
//		this.lastModified = lastModified;
//		this.createdBy = createdBy;
//		this.modifiedBy = modifiedBy;
//	}
//
//	public Company(String companyName, IndrustrySector sector, String presence, int totalNumberOfFacility,
//			Calendar createdOn, String createdBy) {
//		super();
//		this.companyName = companyName;
//		this.sector = sector;
//		this.presence = presence;
//		this.totalNumberOfFacility = totalNumberOfFacility;
//		this.createdOn = createdOn;
//		this.createdBy = createdBy;
//	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public IndrustrySector getSector() {
		return sector;
	}

	public void setSector(IndrustrySector sector) {
		this.sector = sector;
	}

	public String getPresence() {
		return presence;
	}

	public List<Facility> getFacility() {
		return facility;
	}

	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	public int getTotalNumberOfFacility() {
		return totalNumberOfFacility;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setTotalNumberOfFacility(int totalNumberOfFacility) {
		this.totalNumberOfFacility = totalNumberOfFacility;
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
