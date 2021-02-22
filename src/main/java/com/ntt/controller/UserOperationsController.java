package com.ntt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.dto.CategoryDTO;
import com.ntt.entityConverter.DTOUtil;
import com.ntt.exception.CategoryNotFoundException;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Category;
import com.ntt.model.Product;
import com.ntt.model.SubCategory;
import com.ntt.service.UserOperationsService;

@RestController
@RequestMapping("/UserOperations")
public class UserOperationsController {
	
	@Autowired
	private UserOperationsService userOperationsService;

	
	/*
	 * @GetMapping("/getallSubCatByCatId/{id}") public CategoryDTO
	 * getSubCategoryById(@PathVariable long id) throws CategoryNotFoundException{
	 * return userOperationsService.getSubCatById(id); }
	 */
	
	
	/*
	 * @GetMapping("/getallProductsBySubCatId/{id}") public
	 * List<SubCategory>getProductsById(@PathVariable long id) throws
	 * ResourceNotFoundException{ return userOperationsService.getProductsById(id);
	 * }
	 */
	
	@GetMapping("/{id}") 
	public CategoryDTO getAllCombinedByCatId(@PathVariable long id) throws CategoryNotFoundException{ 
		return userOperationsService.getAllCombinedByCatId(id);
	}
	
	
	 
}


