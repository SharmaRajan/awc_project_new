package com.codewithrajan.blogapiapp.service.impl;


import com.codewithrajan.blogapiapp.entities.Category;
import com.codewithrajan.blogapiapp.exceptions.ResourceNotFoundException;
import com.codewithrajan.blogapiapp.payloads.CategoryDTO;
import com.codewithrajan.blogapiapp.repository.ICategoryRepo;
import com.codewithrajan.blogapiapp.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDTO createCategory(CategoryDTO newDto) {
		
		Category category = this.modelMapper.map(newDto, Category.class);
		
		Category addedCategory = this.categoryRepo.save(category);
		
		return this.modelMapper.map(addedCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO newDto, Integer catId) {

		Category oldCategory = this.categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id: ", catId));
		
		oldCategory.setCategoryTitle(newDto.getCategoryTitle());
		oldCategory.setCategoryDescription(newDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepo.save(oldCategory);
		
		return this.modelMapper.map(updatedCategory, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer catId) {

		Category category = this.categoryRepo.findById(catId)
						.orElseThrow(() -> new ResourceNotFoundException("Category " , "category id: " , catId));
		
		this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDTO getCategoryById(Integer catId) {

		Category category = this.categoryRepo.findById(catId)
						.orElseThrow(() -> new ResourceNotFoundException("category ","category id: ",catId));
		
		return this.modelMapper.map(category, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		
		List<Category> categories = this.categoryRepo.findAll();
		
		List<CategoryDTO> categoryDtoList =categories.stream()
				.map((cat) -> this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		
		return categoryDtoList;
	}

}
