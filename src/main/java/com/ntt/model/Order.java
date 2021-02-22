package com.ntt.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "GEN_ORDERS", sequenceName = "SEQ_ORDERS")
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="USERID")
	private long userId;
	
	@Column(name="ORDERDATE")
	private String orderDate;
	
	@Column(name="DELIVERDATE")
	private String deliverDate;
	
	@Column(name="TOTALAMOUNT")
	private int totalAmount;
	
	@Column(name="ADDRESS")
	private String address;
	
	
	  @OneToMany(mappedBy = "order" , fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	  private Set<ProductOrders> productOrders;
	  
	  
	  public Set<ProductOrders> getProductOrders() {
			return productOrders;
		}
		public void setProductOrders(Set<ProductOrders> productOrders) {
			this.productOrders = productOrders;
		}
	 
	
	public Order() {
		super();
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Order(long orderId, long userId, String orderDate, String deliverDate, int totalAmount, String address,
			Set<ProductOrders> productOrders) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.deliverDate = deliverDate;
		this.totalAmount = totalAmount;
		this.address = address;
		this.productOrders = productOrders;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", deliverDate="
				+ deliverDate + ", totalAmount=" + totalAmount + ", address=" + address + ", productOrders="
				+ productOrders + "]";
	}
	
	
}
