package com.ntt.dto;

import com.ntt.model.Order;

public class ProductOrdersDTO {
	
	private long OrderLine;
	private int ProductId;
	private int Quantity;
	private Order order;
	
	/*
	 * public long getOrderId() { return OrderId; } public void setOrderId(long
	 * orderId) { OrderId = orderId; }
	 */
	public long getOrderLine() {
		return OrderLine;
	}
	public void setOrderLine(long orderLine) {
		OrderLine = orderLine;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public ProductOrdersDTO(long orderLine, int productId, int quantity, Order order) {
		super();
		OrderLine = orderLine;
		ProductId = productId;
		Quantity = quantity;
		this.order = order;
	}
	public ProductOrdersDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ProductOrdersDTO [OrderLine=" + OrderLine + ", ProductId=" + ProductId + ", Quantity=" + Quantity
				+ ", order=" + order + "]";
	}

}
