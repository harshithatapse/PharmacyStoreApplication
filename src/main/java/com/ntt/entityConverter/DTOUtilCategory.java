package com.ntt.entityConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.ntt.dto.CategoryDTO;
import com.ntt.model.Category;

public class DTOUtilCategory {
	
	public static List<CategoryDTO> buildCategoryDTO(List<Category> categories) {
		
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		
		for(Category category : categories)
		{
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryCode(category.getCategoryCode());
		categoryDTO.setCategoryDescription(category.getCategoryDescription());
		
		categoryDTOList.add(categoryDTO);
		}
		
		return categoryDTOList;
		
	}

public static Page<CategoryDTO> buildCategoryDTO(Page<Category> allCategories) {
		
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		
		for(Category category : allCategories)
		{
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryCode(category.getCategoryCode());
		categoryDTO.setCategoryDescription(category.getCategoryDescription());
		
		categoryDTOList.add(categoryDTO);
		}
		
		Page <CategoryDTO>pages = new PageImpl<>(categoryDTOList,allCategories.getPageable(),allCategories.getTotalElements()); 
		
		return pages;
		
	}

}
