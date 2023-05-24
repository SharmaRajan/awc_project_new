package com.dalmia.dalmia.request.dto;

import java.util.List;

import com.dalmia.dalmia.entity.Facility;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//dto

public class CompanyRequestDto {


	private int companyId;

//	@Pattern(regexp= "[A-Z][a-z]*\\s[a-zA-Z]*$", message = "company name not valid")
	@Pattern(regexp = "\\w*\s\\w*", message = "company name not valid")
	@NotNull(message = "company name not be null")
	private String companyName;

	
	
	private int sectorId;

	@NotNull(message = "presence not be null")
	private String presence;

	private int totalNumberOfFacility;

//	private List<Facility> facility;

	@NotNull(message = "created by not be null")
	private String createdBy;
	
	public CompanyRequestDto() {
	}

//	public int getCompanyId() {
//		return companyId;
//	}
//
//	public void setCompanyId(int companyId) {
//		this.companyId = companyId;
//	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	

}
