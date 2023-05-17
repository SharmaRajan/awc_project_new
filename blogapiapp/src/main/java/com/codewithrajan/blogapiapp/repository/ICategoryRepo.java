package com.codewithrajan.blogapiapp.repository;


import com.codewithrajan.blogapiapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Integer>{

}
