package com.ntt.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.dtoConverter.DTOToEntityCategory;
import com.ntt.dtoConverter.DTOToEntityProduct;
import com.ntt.dtoConverter.DTOToEntitySubCategory;
import com.ntt.entityConverter.DTOUtil;
import com.ntt.entityConverter.DTOUtilCatAndSubCat;
import com.ntt.entityConverter.DTOUtilSubCatAndProducts;
import com.ntt.exception.CategoryNotFoundException;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Category;
import com.ntt.model.Product;
import com.ntt.model.SubCategory;
import com.ntt.repository.CategoryRepository;
import com.ntt.repository.ProductRepository;
import com.ntt.repository.SubCategoryRepository;
import com.ntt.service.UserOperationsService;

@Service
public class UserOperationsServiceImpl implements UserOperationsService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	Logger log = LoggerFactory.getLogger(UserOperationsServiceImpl.class);

	/*
	 * @Override public CategoryDTO getSubCatById(long id) { Category category =
	 * categoryRepository.findById(id); if (Objects.isNull(category)) {
	 * log.error(" Error : Enter correct Category Id"); throw new
	 * CategoryNotFoundException("Category not found for this Category Id :: " +
	 * id); } return DTOUtilCatAndSubCat.SubCategoryBuilder(category); }
	 */

	/*
	 * @Override public List<SubCategory> getProductsById(long id) {
	 * List<SubCategory> subCategory =
	 * subCategoryRepository.findBySubCategoryId(id); return
	 * DTOUtilSubCatAndProducts.ProductBuilder(subCategory); }
	 */

	@Override
	public CategoryDTO getAllCombinedByCatId(long id) {
		CategoryDTO categoryDTO = new CategoryDTO();
		Category category = categoryRepository.findById(id);
		if (Objects.isNull(category)) {
			log.error(" Error : Enter correct Category Id");
			throw new CategoryNotFoundException("Category not found for this Category Id :: " + id);
		}
		// categoryDTO.setCategory(category);
		return DTOUtil.buildCategoryDTO(category);
	}

	/*
	 * @Override public CategoryDTO insertCatSubCatAndProducts(CategoryDTO
	 * categoryDTO) {
	 * 
	 * Category category = DTOToEntityCategory.buildCategoryEntity(categoryDTO);
	 * categoryRepository.save(category); Set<SubCategory> subCategorySet =
	 * DTOToEntitySubCategory.buildSubCategoryEntity(categoryDTO, category);
	 * Set<SubCategory> subCategorySetFromRepository = new HashSet<SubCategory>();
	 * Set<SubCategoryDTO> subCategoryDTOSet = categoryDTO.getSubCategoryDTOSet();
	 * Set<Products> productSet =
	 * DTOToEntityProduct.buildProductEntity(subCategoryDTOSet, subCategorySet);
	 * 
	 * 
	 * Category category = DTOToEntityProduct.buildCategoryEntity(categoryDTO);
	 * 
	 * return DTOUtil.buildCategoryDTO(categoryRepository.save(category));
	 * 
	 * }
	 */

}
