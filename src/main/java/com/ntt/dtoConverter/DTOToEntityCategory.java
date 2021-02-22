package com.ntt.dtoConverter;

import com.ntt.dto.CategoryDTO;
import com.ntt.model.Category;

public class DTOToEntityCategory {
	
public static Category buildCategoryEntity(CategoryDTO categoryDTO) {
		
		Category category = new Category();
		
		category.setCategoryCode(categoryDTO.getCategoryCode());
		category.setCategoryDescription(categoryDTO.getCategoryDescription());
		
		return category;
			 
	}

}
