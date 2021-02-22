package com.ntt.entityConverter;

import java.util.HashSet;
import java.util.Set;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.model.Category;
import com.ntt.model.SubCategory;

public class DTOUtilCatAndSubCat {
	
	public static CategoryDTO SubCategoryBuilder(Category category)
	{
		
	CategoryDTO categoryDTO = new CategoryDTO();
	categoryDTO.setCategoryId(category.getCategoryId());
	categoryDTO.setCategoryCode(category.getCategoryCode());
	categoryDTO.setCategoryDescription(category.getCategoryDescription());
	
	Set<SubCategory> subCategories = category.getSubCategory();
	  Set<SubCategoryDTO> subCategoryDTOSet = new HashSet<>();
	 
	 
	  for(SubCategory subCategory:subCategories) 
	  {
	  SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
	  subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
	  subCategoryDTO.setSubCategoryDescription(subCategory.getSubCategoryDescription());
	  subCategoryDTO.setSubCategoryCode(subCategory.getSubCategoryCode());
	  
	  subCategoryDTOSet.add(subCategoryDTO);
	  }
	
	categoryDTO.setSubCategoryDTOSet(subCategoryDTOSet);
	return categoryDTO;
	}
	
}
