package com.dalmia.crudapp.repository;

import com.dalmia.crudapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompanyRepo extends JpaRepository<Company,Long> {

    Optional<Company> findById(Long id);

    @Query(value = "Select comp from Company comp where comp.companyName= ?1")
    Optional<Company> findByName(String companyName);

}
