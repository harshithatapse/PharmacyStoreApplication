package com.ntt.entityConverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.ntt.dto.OrderDTO;
import com.ntt.dto.ProductOrdersDTO;
import com.ntt.model.Order;
import com.ntt.model.ProductOrders;

public class DTOUtilOrders {
		
		public static List<OrderDTO> buildOrderDTO(List<Order> orders) {
			
			List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
			
			for(Order order : orders)
			{
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
			  
			orderDTOList.add(orderDTO);
				 
		}
			
			return orderDTOList;
			
		}

		public static Page<OrderDTO> buildOrderDTO(Page<Order> allOrders) {
			
List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
			
			for(Order order : allOrders)
			{
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
			  
			orderDTOList.add(orderDTO);
				 
		}
			
			Page <OrderDTO>pages = new PageImpl<>(orderDTOList,allOrders.getPageable(),allOrders.getTotalElements()); 
			return pages;
			
		}

}
