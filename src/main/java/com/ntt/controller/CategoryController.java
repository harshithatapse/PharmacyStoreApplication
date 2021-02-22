package com.ntt.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.ProductDTO;
import com.ntt.model.Category;
import com.ntt.service.CategoryService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/category")

public class CategoryController {
		
		@Autowired
		private CategoryService categoryService;
		
		@GetMapping("/getallcategory")
		public List<CategoryDTO> getAllCategories(){
			return categoryService.getAllCategories();
		}
		
		@GetMapping("/getallPageableCategory")
		public Page<CategoryDTO> getAllPageableProducts(@RequestParam(value = "page", required = false) Integer pageNumber,
	            @RequestParam(value = "size", required = false) Integer size,
	            @RequestParam(value = "sortBy", required = false) String sort){ 
			if (Objects.isNull(pageNumber))
	            pageNumber = 0;
	        if (Objects.isNull(size))
	            size = 50;
	        if (Objects.isNull(sort))
	            sort = "categoryId";
			Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(sort).descending());
			return categoryService.getAllPageableCategory(pageable);
		}

	}

