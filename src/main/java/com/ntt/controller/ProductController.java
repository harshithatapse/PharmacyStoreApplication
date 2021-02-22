package com.ntt.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.dto.ProductDTO;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Product;
import com.ntt.model.SubCategory;
import com.ntt.service.ProductService;

@RestController
@RequestMapping("/api/v2")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getallproducts")
	public List<ProductDTO> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	
	@GetMapping("/getallPageableProducts") 
	public Page<ProductDTO> getAllPageableProducts(@RequestParam(value = "page", required = false) Integer pageNumber,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "sortBy", required = false) String sort){ 
		if (Objects.isNull(pageNumber))
            pageNumber = 0;
        if (Objects.isNull(size))
            size = 50;
        if (Objects.isNull(sort))
            sort = "ProductId";
		Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(sort).descending());
		return productService.getAllPageableProducts(pageable);
	}
	 

}
