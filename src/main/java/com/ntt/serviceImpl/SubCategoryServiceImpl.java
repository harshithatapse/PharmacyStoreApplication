package com.ntt.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.ProductDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.entityConverter.DTOUtilCatAndSubCat;
import com.ntt.entityConverter.DTOUtilCategory;
import com.ntt.entityConverter.DTOUtilSubCategory;
import com.ntt.exception.CategoryNotFoundException;
import com.ntt.model.Category;
import com.ntt.model.SubCategory;
import com.ntt.repository.CategoryRepository;
import com.ntt.repository.SubCategoryRepository;
import com.ntt.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	private SubCategoryRepository subcategoryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(SubCategoryServiceImpl.class);

	@Override
	public List<SubCategoryDTO> getAllSubCategories() {
		return DTOUtilSubCategory.buildSubCategoryDTO(subcategoryRepository.findAll());
	}

	@Override
	public Page<SubCategoryDTO> getAllPageableSubCategory(Pageable pageable) {
		Page<SubCategory> allCategories = subcategoryRepository.findAll(pageable);
		return allCategories.map(subcategory -> {
			return modelMapper.map(subcategory, SubCategoryDTO.class);
		});
		  //return DTOUtilSubCategory.buildSubCategoryDTO(allCategories);
	}

	@Override
	public CategoryDTO getSubCatById(long id) {
		Category category = categoryRepository.findById(id);
		if (Objects.isNull(category)) {
			log.error(" Error : Enter correct Category Id");
			throw new CategoryNotFoundException("Category not found for this Category Id :: " + id);
		}
		
		return DTOUtilCatAndSubCat.SubCategoryBuilder(category);
	}

}
