package com.ntt.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ntt.dto.CategoryDTO;
import com.ntt.dto.OrderDTO;
import com.ntt.dtoConverter.DTOToEntityOrder;
import com.ntt.dtoConverter.DTOToEntityProductOrders;
import com.ntt.exception.OrderNotFoundException;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;
import com.ntt.model.User;
import com.ntt.service.OrderService;


@RestController
@RequestMapping("/order")

public class OrderController {
		
		@Autowired
		private OrderService orderService ;
	 
		@GetMapping("/")
		public List<OrderDTO> getAllOrders(){
			return orderService.getAllOrders();
		}
		
	
	    @PostMapping("/") 
	    public OrderDTO placeOrder(@Validated @RequestBody OrderDTO orderDTO) {
	    	return orderService.placeOrder(orderDTO);
	    	//Order order = DTOToEntityOrder.buildOrderEntity(orderDTO);
	    	//orderRepository.save(order);
	    	//Order order1 = DTOToEntityProductOrders.buildProductOrderEntity(order,orderDTO);
	        //return orderService.placeOrder(order,order1);
	        //orderService.placeOrder(order1);
	    }
	 
		
		@PostMapping("/{id}")
		public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") long OrderId , @RequestBody Order orderDetails)throws OrderNotFoundException{
			return orderService.updateUsers(OrderId,orderDetails);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") long OrderId) throws OrderNotFoundException{
			return orderService.deleteOrder(OrderId);
		}
		
		@GetMapping("/getallPageableOrders")
		public Page<OrderDTO> getAllPageableOrders(@RequestParam(value = "page", required = false) Integer pageNumber,
	            @RequestParam(value = "size", required = false) Integer size,
	            @RequestParam(value = "sortBy", required = false) String sort){ 
			if (Objects.isNull(pageNumber))
	            pageNumber = 0;
	        if (Objects.isNull(size))
	            size = 50;
	        if (Objects.isNull(sort))
	            sort = "orderId";
			Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(sort).descending());
			return orderService.getAllPageableOrders(pageable);
		}
}
