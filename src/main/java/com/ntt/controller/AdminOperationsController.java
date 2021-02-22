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
import com.ntt.dto.OrderDTO;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;
import com.ntt.service.AdminOperationsService;

@RestController
@RequestMapping("/AdminOperations")
public class AdminOperationsController {
	
	@Autowired
	private AdminOperationsService adminOperationsService;
	
	@GetMapping("/")
	public List<ProductOrders> getAllProductOrders(){
		return adminOperationsService.getAllProductOrders();
	}
	
	@GetMapping("/{id}")
	public OrderDTO getOrderById(@PathVariable long id) {
		return adminOperationsService.getOrderById(id);
	}
	
	@PostMapping("/")
	public CategoryDTO insertCatSubCatAndProducts(@Validated @RequestBody CategoryDTO categoryDTO) {
		return adminOperationsService.insertCatSubCatAndProducts(categoryDTO);
	}
	
}