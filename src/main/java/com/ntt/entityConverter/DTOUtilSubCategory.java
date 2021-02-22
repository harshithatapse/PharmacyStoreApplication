package com.ntt.entityConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.ntt.dto.SubCategoryDTO;
import com.ntt.model.SubCategory;

public class DTOUtilSubCategory {
	
	public static SubCategoryDTO buildSingleSubCategoryDTO(SubCategory subCategory)
	{
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
		subCategoryDTO.setSubCategoryDescription(subCategory.getSubCategoryDescription());
		subCategoryDTO.setSubCategoryCode(subCategory.getSubCategoryCode());
		
		return subCategoryDTO;
	}
	
public static List<SubCategoryDTO> buildSubCategoryDTO(List<SubCategory> subCategories) {
		
		//List<SubCategoryDTO> subCategoryDTOList = new ArrayList<SubCategoryDTO>();
		
		return subCategories.stream().map(subcategory -> buildSingleSubCategoryDTO(subcategory)).collect(Collectors.toList());
		
//		for(SubCategory subCategory : subCategories)
//		{
//			SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
//			  subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
//			  subCategoryDTO.setSubCategoryDescription(subCategory.getSubCategoryDescription());
//			  subCategoryDTO.setSubCategoryCode(subCategory.getSubCategoryCode());
//		
//			subCategoryDTOList.add(subCategoryDTO);
//		}
		
	//	return subCategoryDTOList;
		
	}

public static Page<SubCategoryDTO> buildSubCategoryDTO(Page<SubCategory> allSubCategories) {
	
	List<SubCategoryDTO> subCategoryDTOList = new ArrayList<SubCategoryDTO>();
	
	for(SubCategory subCategory : allSubCategories)
	{
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		  subCategoryDTO.setSubCategoryId(subCategory.getSubCategoryId());
		  subCategoryDTO.setSubCategoryDescription(subCategory.getSubCategoryDescription());
		  subCategoryDTO.setSubCategoryCode(subCategory.getSubCategoryCode());
	
		subCategoryDTOList.add(subCategoryDTO);
	}
	
	Page <SubCategoryDTO>pages = new PageImpl<>(subCategoryDTOList,allSubCategories.getPageable(),allSubCategories.getTotalElements());
	
	return pages;
	
}

}
