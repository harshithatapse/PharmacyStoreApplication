package com.ntt.entityConverter;

import java.util.HashSet;
import java.util.Set;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.ProductDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.model.Category;
import com.ntt.model.Product;
import com.ntt.model.SubCategory;

public class DTOUtil {
	
	public static CategoryDTO buildCategoryDTO(Category category) {
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
		  
		  Set<ProductDTO> productDTOSet = new HashSet<>();
		  Set<Product> products = subCategory.getProduct();
		  
		  for(Product product: products) 
		  {
		  ProductDTO productDTO = new ProductDTO();
		  productDTO.setProductId(product.getProductId());
		  productDTO.setProductCode(product.getProductCode());
		  productDTO.setProductDescription(product.getProductDescription());
		  productDTO.setPrice(product.getPrice());
		  productDTO.setQuantity(product.getQuantity());
		  productDTOSet.add(productDTO);
		  }
		 
		  subCategoryDTO.setProductDTOSet(productDTOSet);
		  subCategoryDTOSet.add(subCategoryDTO);
		  
		  }
		
		categoryDTO.setSubCategoryDTOSet(subCategoryDTOSet);
		return categoryDTO;
		
		
	}
	
	
}
