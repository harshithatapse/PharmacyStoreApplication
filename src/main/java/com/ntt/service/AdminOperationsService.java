package com.ntt.service;

import java.util.List;

import com.ntt.dto.CategoryDTO;
import com.ntt.dto.OrderDTO;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;

public interface AdminOperationsService {

	List<ProductOrders> getAllProductOrders();

	OrderDTO getOrderById(long id);

	CategoryDTO insertCatSubCatAndProducts(CategoryDTO categoryDTO);

}
