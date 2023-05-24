package com.dalmia.dalmia.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;	

@Entity
@Table(name = "business_opportunity")
public class BusinessOpportunity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "source")
	private String source;
	
	@ManyToOne
	@JoinColumn(name = "company_name")
	private Company companyName;
	
	@ManyToOne
	@JoinColumn(name = "facility_name")
	private Facility facilityName;
	
	@OneToMany
//	@JoinColumn(name = "contact_person")
	private List<ContactPerson> contactPerson;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "segment")
	private String segment;
	
	@OneToMany
	private List<User> assignedTo;
	
	public BusinessOpportunity() {
	}

	public BusinessOpportunity(String source, Company companyName) {
		this.source = source;
		this.companyName = companyName;
	}

	public BusinessOpportunity(String source, Company companyName, Facility facilityName,
			List<ContactPerson> contactPerson, Date createdOn, String createdBy, String segment,
			List<User> assignedTo) {
		super();
		this.source = source;
		this.companyName = companyName;
		this.facilityName = facilityName;
		this.contactPerson = contactPerson;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.segment = segment;
		this.assignedTo = assignedTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Company getCompanyName() {
		return companyName;
	}

	public void setCompanyName(Company companyName) {
		this.companyName = companyName;
	}

	public Facility getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(Facility facilityName) {
		this.facilityName = facilityName;
	}

	public List<ContactPerson> getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(List<ContactPerson> contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public List<User> getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(List<User> assignedTo) {
		this.assignedTo = assignedTo;
	}

	
}
