package com.codewithrajan.blogapiapp.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

	private Integer catId;
	
	@NotBlank
	@Size(min=4, message = "min size of title is 10")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "min size of description is 10")
	private String categoryDescription;
	
}
