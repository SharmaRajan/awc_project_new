package com.eazybytes.repository;

import com.eazybytes.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

    // It is called as Derived method name query
    List<Customer> findByEmail(String email);

}
