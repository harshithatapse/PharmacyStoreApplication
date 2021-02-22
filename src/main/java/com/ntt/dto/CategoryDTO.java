package com.ntt.dto;

import java.util.Set;

import com.ntt.model.Category;
import com.ntt.model.SubCategory;

public class CategoryDTO {
	
	private long categoryId;
	private String categoryCode;
	private String categoryDescription;
	
	private Set<SubCategoryDTO> subCategoryDTOSet;

	public long getCategoryId() {
		return categoryId;
	}

	public CategoryDTO(long categoryId, String categoryCode, String categoryDescription,
			Set<SubCategoryDTO> subCategoryDTOSet) {
		super();
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.categoryDescription = categoryDescription;
		this.subCategoryDTOSet = subCategoryDTOSet;
	}

	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Set<SubCategoryDTO> getSubCategoryDTOSet() {
		return subCategoryDTOSet;
	}

	public void setSubCategoryDTOSet(Set<SubCategoryDTO> subCategoryDTOSet) {
		this.subCategoryDTOSet = subCategoryDTOSet;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryCode=" + categoryCode + ", categoryDescription="
				+ categoryDescription + ", subCategoryDTOSet=" + subCategoryDTOSet + "]";
	}	
	
}
