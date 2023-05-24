package com.dalmia.dalmia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	private String id;

	
	@ManyToOne
	@JoinColumn(name = "bo")
	private BusinessOpportunity bo;
	
	public User() {
	}
	
	
	
	public User(String id, BusinessOpportunity bo) {
		super();
		this.id = id;
		this.bo = bo;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User(String id) {
		super();
		this.id = id;
	}

	public BusinessOpportunity getBo() {
		return bo;
	}

	public void setBo(BusinessOpportunity bo) {
		this.bo = bo;
	}
	
	
	
	
}
