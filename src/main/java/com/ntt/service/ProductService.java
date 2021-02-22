package com.ntt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntt.dto.ProductDTO;
import com.ntt.model.Product;

public interface ProductService {
	
	public List<ProductDTO> getAllProducts();

	//public Product getProductsDetailsBySubCatId(long id);

	public Page<ProductDTO> getAllPageableProducts(Pageable pageable);

}
