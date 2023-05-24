package com.dalmia.dalmia.response.dto;

public class IndrustrySectorResponseDto {
	

	private int sectorId;
	
	private String sector;
	
	private String Description;

	private String status;
	
	public IndrustrySectorResponseDto() {
	}

	public IndrustrySectorResponseDto(int sectorId, String sector, String description, String status) {
		super();
		this.sectorId = sectorId;
		this.sector = sector;
		Description = description;
		this.status = status;
	}

	public int getIndrustrySectorid() {
		return sectorId;
	}

	public void setIndrustrySectorid(int sectorId) {
		this.sectorId = sectorId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
