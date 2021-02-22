package com.ntt.dtoConverter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.ProductDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.model.Category;
import com.ntt.model.Product;
import com.ntt.model.SubCategory;

public class DTOToEntityProduct {
	
	/*
	 * public static Set<Product> buildProductEntity(Set<SubCategoryDTO>
	 * subCategoryDTOSet, Set<SubCategory> subCategorySet) {
	 * 
	 * Iterator<SubCategoryDTO> it = subCategoryDTOSet.iterator();
	 * 
	 * while(it.hasNext()) { Set<ProductDTO> productsDTO = new HashSet<>();
	 * productsDTO.add(subCategoryDTOSet.next()); Set<Product> productsSet = new
	 * HashSet<>();
	 * 
	 * for(ProductDTO productDTO:productsDTO) {
	 * 
	 * product = new Product();
	 * 
	 * product.setSubCategory(subCategorySet);
	 * product.setSubCategoryCode(subCategoryDTO.getSubCategoryCode());
	 * product.setSubCategoryDescription(subCategoryDTO.getSubCategoryDescription())
	 * ;
	 * 
	 * subCategorySet.add(subCategory);
	 * 
	 * }
	 * 
	 * 
	 * return null; }
	 * 
	 * }
	 */

	public static Category buildCategoryEntity(CategoryDTO categoryDTO)
	{
		Category category = new Category();
		
		category.setCategoryCode(categoryDTO.getCategoryCode());
		category.setCategoryDescription(categoryDTO.getCategoryDescription());
		
		Set<SubCategoryDTO> subCategoryDTOSet = categoryDTO.getSubCategoryDTOSet();
		
		Set<SubCategory> subCategories = new HashSet<>();
		
		for(SubCategoryDTO subCategoryDTO: subCategoryDTOSet)
		{
			SubCategory subCategory = new SubCategory();
				subCategory.setCategory(category);
				subCategory.setSubCategoryCode(subCategoryDTO.getSubCategoryCode());
				subCategory.setSubCategoryDescription(subCategoryDTO.getSubCategoryDescription());
				
			Set<ProductDTO> productsDTOSet = subCategoryDTO.getProductDTOSet();
				
			Set<Product> productsSet = new HashSet<>();
			
			for(ProductDTO productsDTO : productsDTOSet)
			{
			Product product = new Product();
			product.setSubCategory(subCategory);
			product.setProductCode(productsDTO.getProductCode());
			product.setProductDescription(productsDTO.getProductDescription());
			product.setPrice(productsDTO.getPrice());
			product.setQuantity(productsDTO.getQuantity());

			productsSet.add(product);
			}	

			subCategory.setProduct(productsSet);
			
			subCategories.add(subCategory);
			
		}
		
		
		category.setSubCategory(subCategories);
		
		return category;
	}
	
	

}
