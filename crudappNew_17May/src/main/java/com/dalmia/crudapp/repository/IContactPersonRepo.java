package com.dalmia.crudapp.repository;

import com.dalmia.crudapp.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactPersonRepo extends JpaRepository<ContactPerson,Long> {
}
