package com.codewithrajan.blogapiapp.service;


import com.codewithrajan.blogapiapp.payloads.CategoryDTO;

import java.util.List;

public interface ICategoryService {

	// create
	CategoryDTO createCategory(CategoryDTO newDto);
	
	// update
	CategoryDTO updateCategory(CategoryDTO newDto, Integer catId);
	
	// delete
	void deleteCategory(Integer catId);
	
	// get
	CategoryDTO getCategoryById(Integer catId);
	
	// getAll
	List<CategoryDTO> getAllCategory();
}
