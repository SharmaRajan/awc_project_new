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
@Table(name = "contact_person")
public class ContactPerson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_person_id")
	private int contactPersonId;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number")
	private long number;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "contact_details")
	private String contactDetails;
	

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
	
	
//	@Column(name = "address_detail")
//	private String addressDetail;
//	
//	@Column(name = "address_line2")
//	private String addressLine2;
//	
//	@Column(name = "pincode")
//	private int pincode;
//	
//	@Column(name = "district")
//	private String district;
//	
//	@Column(name = "state")
//	private String state;
//	
//	@Column(name = "latitude")
//	private String latitude;
//	
//	@Column(name = "longitude")
//	private String longitude;
	
	
	
	
	public ContactPerson() {
	}

	public ContactPerson(String name, long number, String designation, String emailId, String contactDetails) {
		super();
		this.name = name;
		this.number = number;
		this.designation = designation;
		this.emailId = emailId;
		this.contactDetails = contactDetails;
	}

	
	
//	public ContactPerson(String name, long number, String designation, String emailId, String contactDetails,
//			String addressDetail, String addressLine2, int pincode, String district, String state, String latitude,
//			String longitude) {
//		super();
//		this.name = name;
//		this.number = number;
//		this.designation = designation;
//		this.emailId = emailId;
//		this.contactDetails = contactDetails;
//		this.addressDetail = addressDetail;
//		this.addressLine2 = addressLine2;
//		this.pincode = pincode;
//		this.district = district;
//		this.state = state;
//		this.latitude = latitude;
//		this.longitude = longitude;
//	}

	
	
	
//	public ContactPerson(String name, long number, String designation, String emailId, String contactDetails,
//			String addressDetail) {
//		super();
//		this.name = name;
//		this.number = number;
//		this.designation = designation;
//		this.emailId = emailId;
//		this.contactDetails = contactDetails;
//		this.addressDetail = addressDetail;
//	}
	
	public int getContactPersonId() {
		return contactPersonId;
	}
	
	public void setContactPersonId(int contactPersonId) {
		this.contactPersonId = contactPersonId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	
	
	
}
