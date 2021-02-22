package com.ntt.dtoConverter;

import java.util.HashSet;
import java.util.Set;

import com.ntt.dto.OrderDTO;
import com.ntt.dto.ProductOrdersDTO;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;

public class DTOToEntityProductOrders {
	
	public static Set<ProductOrders> buildProductOrderEntity(OrderDTO orderDTO, Order order) {
		
		//Order order = new Order();
		
		Set<ProductOrdersDTO> productOrdersDTO = orderDTO.getProductOrdersDTOSet();
		  Set<ProductOrders> productOrdersSet = new HashSet<>();
		  
		  for(ProductOrdersDTO productOrderDTO:productOrdersDTO) 
		  {
			 ProductOrders productOrders = new ProductOrders();
			 //productOrders.setOrderLine(productOrderDTO.getOrderLine());
			 //productOrders.setOrderId(order.getOrderId());
			 //order.setProductOrders(null);
			 productOrders.setOrder(order);
			 //productOrders.setOrder(productOrderDTO.getOrder());
			 productOrders.setProductId(productOrderDTO.getProductId());
			 productOrders.setQuantity(productOrderDTO.getQuantity());
			 
			 productOrdersSet.add(productOrders);
			 
		  }
		  
		return productOrdersSet;
	}

}
