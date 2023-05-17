package com.codewithrajan.blogapiapp.repository;

import com.codewithrajan.blogapiapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role,Integer> {

}
