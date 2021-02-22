package com.ntt.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ntt.dto.OrderDTO;
import com.ntt.dtoConverter.DTOToEntityOrder;
import com.ntt.dtoConverter.DTOToEntityProductOrders;
import com.ntt.entityConverter.DTOUtilCategory;
import com.ntt.entityConverter.DTOUtilOrderProductOrders;
import com.ntt.entityConverter.DTOUtilOrders;
import com.ntt.exception.OrderNotFoundException;
import com.ntt.exception.UserNotFoundException;
import com.ntt.model.Category;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;
import com.ntt.model.User;
import com.ntt.repository.OrderRepository;
import com.ntt.repository.ProductOrdersRepository;
import com.ntt.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductOrdersRepository productOrdersRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public List<OrderDTO> getAllOrders() {
		
		  List<Order> orders = orderRepository.findAll(); 
		  List<OrderDTO> dtos = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class))
		  .collect(Collectors.toList()); 
		  return dtos;
		 
		//return DTOUtilOrders.buildOrderDTO(orderRepository.findAll());
	}
	
	
	@Override 
	public OrderDTO placeOrder(OrderDTO orderDTO) {
		Order order = DTOToEntityOrder.buildOrderEntity(orderDTO);
		return DTOUtilOrderProductOrders.buildOrderDTO(orderRepository.save(order));
		/*
		 * System.out.println("order entity before saving" + order);
		 * orderRepository.save(order); System.out.println("order entity after saving" +
		 * order); System.out.println("After order repository save call");
		 * Set<ProductOrders> productOrdersSet =
		 * DTOToEntityProductOrders.buildProductOrderEntity(orderDTO,order);
		 * Set<ProductOrders> productOrdersSetFromRepository = new
		 * HashSet<ProductOrders>(); for(ProductOrders productOrder: productOrdersSet) {
		 * productOrdersSetFromRepository.add(productOrdersRepository.save(productOrder)
		 * ); } order.setProductOrders(productOrdersSetFromRepository);
		 */
		
	}
	 
	
	@Override 
	public ResponseEntity<Order> updateUsers(long orderId, Order orderDetails) throws OrderNotFoundException { 
		Order order = orderRepository.findById(orderId) .orElseThrow(() -> new
				OrderNotFoundException("Order not found for this id :: " + orderId));
		order.setUserId(orderDetails.getUserId());
		order.setOrderDate(orderDetails.getOrderDate());
		order.setDeliverDate(orderDetails.getDeliverDate());
		order.setTotalAmount(orderDetails.getTotalAmount());
		order.setAddress(orderDetails.getAddress()); Order
		order1=orderRepository.save(order); 
		return ResponseEntity.ok().body(order1);
	 }
	 

	@Override
	public ResponseEntity<?> deleteOrder(long OrderId) throws OrderNotFoundException {
		Order order = orderRepository.findById(OrderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found for this id :: " + OrderId));
		this.orderRepository.delete(order);
		return ResponseEntity.ok().build();
	}


	@Override
	public Page<OrderDTO> getAllPageableOrders(Pageable pageable) {
		Page<Order> orders = orderRepository.findAll(pageable);
		return orders.map(allOrders -> {
			return modelMapper.map(allOrders, OrderDTO.class);
		});
		  //return DTOUtilOrders.buildOrderDTO(allOrders);
	}

}
