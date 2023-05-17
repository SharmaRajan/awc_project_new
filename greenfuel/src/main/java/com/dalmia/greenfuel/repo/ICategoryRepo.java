package com.dalmia.greenfuel.repo;

import com.dalmia.greenfuel.manyToMany.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,String> {
}
