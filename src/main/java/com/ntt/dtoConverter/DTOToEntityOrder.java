package com.ntt.dtoConverter;

import java.util.HashSet;
import java.util.Set;

import com.ntt.dto.OrderDTO;
import com.ntt.dto.ProductOrdersDTO;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;

public class DTOToEntityOrder {
	
public static Order buildOrderEntity(OrderDTO orderDTO) {
		
		Order order = new Order();
		//order.setOrderId(orderDTO.getOrderId());
		order.setAddress(orderDTO.getAddress());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setDeliverDate(orderDTO.getDeliverDate());
		order.setUserId(orderDTO.getUserId());
		order.setTotalAmount(orderDTO.getTotalAmount());
		
		  Set<ProductOrdersDTO> productOrdersDTO = orderDTO.getProductOrdersDTOSet();
		  Set<ProductOrders> productOrdersSet = new HashSet<>();
		  
		  for(ProductOrdersDTO productOrderDTO:productOrdersDTO)  
		  {
			  ProductOrders productOrders = new ProductOrders();
			  //productOrders.setOrderLine(productOrderDTO.getOrderLine());
			  productOrders.setOrder(order);
			  productOrders.setProductId(productOrderDTO.getProductId());
			  productOrders.setQuantity(productOrderDTO.getQuantity());
			  
			  productOrdersSet.add(productOrders);
		  
		  }
		  
		  order.setProductOrders(productOrdersSet);
		 
		return order;
			 
	}
}




