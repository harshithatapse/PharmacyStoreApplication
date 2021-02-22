package com.ntt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.ProductDTO;
import com.ntt.entityConverter.DTOUtilCategory;
import com.ntt.entityConverter.DTOUtilProducts;
import com.ntt.model.Category;
import com.ntt.model.Product;
import com.ntt.repository.CategoryRepository;
import com.ntt.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Override
	public List<CategoryDTO> getAllCategories() {
		return DTOUtilCategory.buildCategoryDTO(categoryRepository.findAll());		
	}

	@Override
	public Page<CategoryDTO> getAllPageableCategory(Pageable pageable) {
		log.info("CategoryServiceImpl:getAllPageableCategory");
		Page<Category> allCategories = categoryRepository.findAll(pageable);
		return allCategories.map(category -> {
			return modelMapper.map(category, CategoryDTO.class);
		});
		  //return DTOUtilCategory.buildCategoryDTO(allCategories);
	}
 
}
