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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.SubCategoryDTO;
import com.ntt.exception.CategoryNotFoundException;
import com.ntt.model.SubCategory;
import com.ntt.service.SubCategoryService;

@RestController
@RequestMapping("/api/v2")

public class SubCategoryController {
		
		@Autowired
		private SubCategoryService subcategoryService;
		
		@GetMapping("/getallsubcategory")
		public List<SubCategoryDTO> getAllsubCategories(){
			return subcategoryService.getAllSubCategories();
		}
		
		@GetMapping("/getallPageableSubCategory")
		public Page<SubCategoryDTO> getAllPageableSubCategories(@RequestParam(value = "page", required = false) Integer pageNumber,
	            @RequestParam(value = "size", required = false) Integer size,
	            @RequestParam(value = "sortBy", required = false) String sort){ 
			if (Objects.isNull(pageNumber))
	            pageNumber = 0;
	        if (Objects.isNull(size))
	            size = 5;
	        if (Objects.isNull(sort))
	            sort = "subCategoryId";
			Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(sort).descending());
			return subcategoryService.getAllPageableSubCategory(pageable);
		}
		
		@GetMapping("/getallSubCatByCatId/{id}")
		public CategoryDTO getSubCategoryById(@PathVariable long id) throws CategoryNotFoundException{
			return subcategoryService.getSubCatById(id);
		}

	}
