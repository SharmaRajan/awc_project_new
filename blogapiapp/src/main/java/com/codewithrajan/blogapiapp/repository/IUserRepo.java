package com.codewithrajan.blogapiapp.repository;


import com.codewithrajan.blogapiapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {

    User findByName(String username);

    Optional<User> findByEmail(String email);

}
