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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "facility")
public class Facility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "facility_id")
	private int facilityId;

	@Column(name = "facility_name")
	private String facilityName;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(name = "address_detail")
	private String addressDetail;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "pincode")
	private int pincode;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "location")
	private Location location;

//	@Column(name = "latitude")
//	private String latitude;
//	
//	@Column(name = "longitude")
//	private String longitude;

	@ManyToOne
	@JoinColumn(name = "target_plant")
	private TargetPlant targetPlant;

	@ManyToMany
	@JoinTable(name = "facility_waste_type", joinColumns = @JoinColumn(name = "facility_id"), inverseJoinColumns = @JoinColumn(name = "waste_id"))
	private List<WasteType> wasteType;

	@OneToMany
	@JoinColumn(name = "contact_person_id")
	private Set<ContactPerson> contactPerson;

	@ManyToOne
	@JoinColumn(name = "opportunity_id")
	private BusinessOpportunity opportunity;

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

	public Facility() {
	}

	public Facility(String facilityName, Company company, String addressDetail, String addressLine2, int pincode,
			String district, String state, Location location, TargetPlant targetPlant, List<WasteType> wasteType,
			Set<ContactPerson> contactPerson, BusinessOpportunity opportunity, String approvedBy, String status,
			Calendar createdOn, Calendar lastModified, String createdBy, String modifiedBy) {
		super();
		this.facilityName = facilityName;
		this.company = company;
		this.addressDetail = addressDetail;
		this.addressLine2 = addressLine2;
		this.pincode = pincode;
		this.district = district;
		this.state = state;
		this.location = location;
		this.targetPlant = targetPlant;
		this.wasteType = wasteType;
		this.contactPerson = contactPerson;
		this.opportunity = opportunity;
		this.approvedBy = approvedBy;
		this.status = status;
		this.createdOn = createdOn;
		this.lastModified = lastModified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public TargetPlant getTargetPlant() {
		return targetPlant;
	}

	public void setTargetPlant(TargetPlant targetPlant) {
		this.targetPlant = targetPlant;
	}

	public List<WasteType> getWasteType() {
		return wasteType;
	}

	public void setWasteType(List<WasteType> wasteType) {
		this.wasteType = wasteType;
	}

	public Set<ContactPerson> getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(Set<ContactPerson> contactPerson) {
		this.contactPerson = contactPerson;
	}

	public BusinessOpportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(BusinessOpportunity opportunity) {
		this.opportunity = opportunity;
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
