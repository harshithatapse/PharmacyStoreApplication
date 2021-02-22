package com.ntt.dtoConverter;

import java.util.HashSet;
import java.util.Set;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.model.Category;
import com.ntt.model.SubCategory;

public class DTOToEntitySubCategory {
	
public static Set<SubCategory> buildSubCategoryEntity(CategoryDTO categoryDTO, Category category) {
		
		Set<SubCategoryDTO> subCategoriesDTO = categoryDTO.getSubCategoryDTOSet();
		  Set<SubCategory> subCategorySet = new HashSet<>();
		  
		  for(SubCategoryDTO subCategoryDTO:subCategoriesDTO) 
		  {
			 SubCategory subCategory = new SubCategory();

			 subCategory.setCategory(category);
			 subCategory.setSubCategoryCode(subCategoryDTO.getSubCategoryCode());
			 subCategory.setSubCategoryDescription(subCategoryDTO.getSubCategoryDescription());
			 
			 subCategorySet.add(subCategory);
			 
		  }
		  
		return subCategorySet;
	}


}
