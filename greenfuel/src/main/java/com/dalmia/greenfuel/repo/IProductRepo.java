package com.dalmia.greenfuel.repo;

import com.dalmia.greenfuel.manyToMany.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,String> {
}
