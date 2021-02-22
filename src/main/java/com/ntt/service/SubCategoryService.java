package com.ntt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.model.SubCategory;

public interface SubCategoryService {

	public List<SubCategoryDTO> getAllSubCategories();

	public Page<SubCategoryDTO> getAllPageableSubCategory(Pageable pageable);

	public CategoryDTO getSubCatById(long id);
}
