package com.dalmia.crudapp.repository;

import com.dalmia.crudapp.entity.IndustrySector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIndustrySectorRepo extends JpaRepository<IndustrySector,Long> {
}
