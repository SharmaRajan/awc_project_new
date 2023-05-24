package com.dalmia.dalmia.entity;

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
@Table(name = "waste_generation")
public class WasteGeneration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "waste_generation_id")
	private int wasteGenerationId;
	
	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@OneToMany
	@JoinColumn(name = "waste_type_id")
	private List<WasteType> wasteType;
	
	public WasteGeneration(Facility facility, String facilityName, String facilityAddress, Location location,
			List<WasteType> wasteType) {
		super();
		this.facility = facility;
		this.wasteType = wasteType;
	}
	
	public WasteGeneration() {
	}

	public int getWasteGenerationId() {
		return wasteGenerationId;
	}

	public void setWasteGenerationId(int wasteGenerationId) {
		this.wasteGenerationId = wasteGenerationId;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<WasteType> getWasteType() {
		return wasteType;
	}

	public void setWasteType(List<WasteType> wasteType) {
		this.wasteType = wasteType;
	}

		

}
