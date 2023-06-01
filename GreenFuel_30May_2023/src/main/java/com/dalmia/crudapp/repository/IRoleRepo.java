package com.dalmia.crudapp.repository;

import com.dalmia.crudapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepo extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleCode(String roleCode);

}
