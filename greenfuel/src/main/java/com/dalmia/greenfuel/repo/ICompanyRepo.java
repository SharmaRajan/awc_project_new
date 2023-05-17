package com.dalmia.greenfuel.repo;

import com.dalmia.greenfuel.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//@Repository
//@EnableJpaRepositories
public interface ICompanyRepo extends JpaRepository<Company,Long> {


//    @Query("select ")
    Company findByCompanyName(String name);

//    Company findByName(String name);

//    @Query(nativeQuery = true, value = "select * into tablue from company")
    @Query(nativeQuery = true, value = "create table table1 select * from company")
    void replica();



}
