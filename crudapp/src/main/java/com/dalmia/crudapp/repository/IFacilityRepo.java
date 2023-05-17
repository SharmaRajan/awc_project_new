package com.dalmia.crudapp.repository;

import com.dalmia.crudapp.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepo extends JpaRepository<Facility, Long> {


}
