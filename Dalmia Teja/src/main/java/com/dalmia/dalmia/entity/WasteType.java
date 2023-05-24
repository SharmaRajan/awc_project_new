
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
@Table(name = "waste_type")
public class WasteType {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "waste_type_id")
	private int wasteTypeId;
	
	@Column(name = "type_of_waste")
	private String typeOfWaste;
	
	@Column(name = "waste_description")
	private String wasteDescription;
	

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
	
	
	public WasteType() {
	}

	public WasteType(String typeOfWaste, String wasteDescription) {
		super();
		this.typeOfWaste = typeOfWaste;
		this.wasteDescription = wasteDescription;
	}

	public int getWasteTypeId() {
		return wasteTypeId;
	}

	public void setWasteTypeId(int wasteTypeId) {
		this.wasteTypeId = wasteTypeId;
	}

	public String getTypeOfWaste() {
		return typeOfWaste;
	}

	public void setTypeOfWaste(String typeOfWaste) {
		this.typeOfWaste = typeOfWaste;
	}

	public String getWasteDescription() {
		return wasteDescription;
	}

	public void setWasteDescription(String wasteDescription) {
		this.wasteDescription = wasteDescription;
	}
	
	
	
	

}
