package com.ntt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ntt.dto.OrderDTO;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;

public interface OrderService {
	
	public List<OrderDTO> getAllOrders();
	
	public ResponseEntity<Order> updateUsers(long orderId, Order orderDetails) throws UserNotFoundException;

	public ResponseEntity<?> deleteOrder(long OrderId) throws UserNotFoundException;

	//public Order placeOrder(Order order);

	public OrderDTO placeOrder(OrderDTO oderDTO);

	public Page<OrderDTO> getAllPageableOrders(Pageable pageable);

}
