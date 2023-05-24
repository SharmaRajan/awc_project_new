package com.dalmia.dalmia.response.dto;

import java.util.List;

import com.dalmia.dalmia.entity.Facility;
import com.dalmia.dalmia.entity.IndrustrySector;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//dto

public class CompanyResponseDto {

	private int companyId;
//
////	@Pattern(regexp= "[A-Z][a-z]*\\s[a-zA-Z]*$", message = "company name not valid")
//	@Pattern(regexp = "\\w*\s\\w*", message = "company name not valid")
//	@NotNull(message = "company name not be null")
	private String companyName;

	private IndrustrySectorResponseDto sector;

//	@NotNull(message = "presence not be null")
	private String presence;

	private int totalNumberOfFacility;

	private List<Facility> facility;

//	@NotNull(message = "created by not be null")
	private String createdBy;
	
	public CompanyResponseDto() {
	}

	public CompanyResponseDto(int companyId, String companyName, IndrustrySectorResponseDto sector, String presence,
			int totalNumberOfFacility, List<Facility> facility, String createdBy) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.sector = sector;
		this.presence = presence;
		this.totalNumberOfFacility = totalNumberOfFacility;
		this.facility = facility;
		this.createdBy = createdBy;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public IndrustrySectorResponseDto getSector() {
		return sector;
	}

	public void setSector(IndrustrySectorResponseDto sector) {
		this.sector = sector;
	}

	public String getPresence() {
		return presence;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	public int getTotalNumberOfFacility() {
		return totalNumberOfFacility;
	}

	public void setTotalNumberOfFacility(int totalNumberOfFacility) {
		this.totalNumberOfFacility = totalNumberOfFacility;
	}

	public List<Facility> getFacility() {
		return facility;
	}

	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	

}
