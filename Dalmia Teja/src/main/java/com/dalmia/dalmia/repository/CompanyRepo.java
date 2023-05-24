package com.dalmia.dalmia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dalmia.dalmia.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
	
	public Company findByCompanyName(String name);

}
