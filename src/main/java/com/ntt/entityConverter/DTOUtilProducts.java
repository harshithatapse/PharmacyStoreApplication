package com.ntt.entityConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.ntt.dto.ProductDTO;
import com.ntt.model.Product;

public class DTOUtilProducts {
	
public static List<ProductDTO> buildProductDTO(List<Product> products) {
		
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		
		for(Product product : products)
		{
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(product.getProductId());
			productDTO.setProductCode(product.getProductCode());
			productDTO.setProductDescription(product.getProductDescription());
			productDTO.setPrice(product.getPrice());
			productDTO.setQuantity(product.getQuantity());
		
		productDTOList.add(productDTO);
		}
		
		return productDTOList;
		
	}

public static Page<ProductDTO> buildProductDTO(Page<Product> allProducts)
{
	List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
	
	for(Product product : allProducts)
	{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductCode(product.getProductCode());
		productDTO.setProductDescription(product.getProductDescription());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		
		productDTOList.add(productDTO);
	}
	
	Page <ProductDTO>pages = new PageImpl<>(productDTOList,allProducts.getPageable(),allProducts.getTotalElements()); 
	
	return pages;
}

	
/*
 * public static Page <Product> ProductPageEntityToDTO (Page<Product> product)
 * {​​​​ List<ProductDTO>res= product.stream().map(x ->
 * EntityToDTO(x)).collect(Collectors.toList()); Page <ProductDTO>pages = new
 * PageImpl<>(res); return pages; }
 */
	 


}
