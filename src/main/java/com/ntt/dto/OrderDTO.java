package com.ntt.dto;

import java.util.Set;

public class OrderDTO {
	
	private long orderId;
	private long UserId;
	private String OrderDate;
	private String DeliverDate;
	private int TotalAmount;
	private String Address;
	
	private Set<ProductOrdersDTO> ProductOrdersDTOSet;

	
	  public long getOrderId() { return orderId; }
	  
	  public void setOrderId(long orderId) { this.orderId = orderId; }
	 
	
	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getDeliverDate() {
		return DeliverDate;
	}

	public void setDeliverDate(String deliverDate) {
		DeliverDate = deliverDate;
	}

	public int getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Set<ProductOrdersDTO> getProductOrdersDTOSet() {
		return ProductOrdersDTOSet;
	}

	public void setProductOrdersDTOSet(Set<ProductOrdersDTO> productOrdersDTOSet) {
		ProductOrdersDTOSet = productOrdersDTOSet;
	}

	public OrderDTO(long orderId, long userId, String orderDate, String deliverDate, int totalAmount, String address,
			Set<ProductOrdersDTO> productOrdersDTOSet) {
		super();
		this.orderId = orderId;
		UserId = userId;
		OrderDate = orderDate;
		DeliverDate = deliverDate;
		TotalAmount = totalAmount;
		Address = address;
		ProductOrdersDTOSet = productOrdersDTOSet;
	}

	public OrderDTO() {
		super();
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", UserId=" + UserId + ", OrderDate=" + OrderDate + ", DeliverDate="
				+ DeliverDate + ", TotalAmount=" + TotalAmount + ", Address=" + Address + ", ProductOrdersDTOSet="
				+ ProductOrdersDTOSet + "]";
	}

}
