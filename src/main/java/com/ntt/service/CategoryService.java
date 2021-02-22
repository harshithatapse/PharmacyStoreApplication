package com.ntt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.ProductDTO;
import com.ntt.model.Category;

public interface CategoryService {
	
	public List<CategoryDTO> getAllCategories();

	public Page<CategoryDTO> getAllPageableCategory(Pageable pageable);
	

}
