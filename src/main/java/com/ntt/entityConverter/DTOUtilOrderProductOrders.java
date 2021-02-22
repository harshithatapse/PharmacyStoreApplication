package com.ntt.entityConverter;

import java.util.HashSet;
import java.util.Set;

import com.ntt.dto.OrderDTO;
import com.ntt.dto.ProductOrdersDTO;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;

public class DTOUtilOrderProductOrders {
	
	public static OrderDTO buildOrderDTO(Order order) {
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setAddress(order.getAddress());
		orderDTO.setOrderDate(order.getOrderDate());
		orderDTO.setDeliverDate(order.getDeliverDate());
		orderDTO.setTotalAmount(order.getTotalAmount());
		orderDTO.setUserId(order.getUserId());
		
		Set<ProductOrders> productOrder = order.getProductOrders();
		  Set<ProductOrdersDTO> productOrdersDTOSet = new HashSet<>();
		  
		  for(ProductOrders productOrders:productOrder) 
		  {
			 ProductOrdersDTO productOrdersDTO = new ProductOrdersDTO();
			 productOrdersDTO.setOrderLine(productOrders.getOrderLine());
			 productOrdersDTO.setProductId(productOrders.getProductId());
			 productOrdersDTO.setQuantity(productOrders.getQuantity());
			 
			 productOrdersDTOSet.add(productOrdersDTO);
			 
		  }
		  
		orderDTO.setProductOrdersDTOSet(productOrdersDTOSet);
		return orderDTO;
			 
	}
}

