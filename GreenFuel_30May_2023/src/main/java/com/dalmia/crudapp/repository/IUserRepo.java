package com.dalmia.crudapp.repository;

import com.dalmia.crudapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String emailId);

    Boolean existsByUsername(String username);

//    Boolean existsByEmailId(String emailId);

}
