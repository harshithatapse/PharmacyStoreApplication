package com.ntt.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.ProductDTO;
import com.ntt.entityConverter.DTOUtilProducts;
import com.ntt.model.Product;
import com.ntt.repository.ProductRepository;
import com.ntt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public List<ProductDTO> getAllProducts() {
		return DTOUtilProducts.buildProductDTO(productRepository.findAll());
	}
	
	
	  @Override 
	  public Page<ProductDTO> getAllPageableProducts(Pageable pageable) { 
		  //Pageable secondPageWithFiveElements = PageRequest.of(0, 5);
		  Page<Product> allProducts = productRepository.findAll(pageable);
		  return allProducts.map(product -> {
				return modelMapper.map(product, ProductDTO.class);
			});
		  //return DTOUtilProducts.buildProductDTO(allProducts);
	  }

	/*
	 * @Override public Product getProductsDetailsBySubCatId(long id) { return
	 * productRepository.findBySubCategoryId(id); }
	 */

}
