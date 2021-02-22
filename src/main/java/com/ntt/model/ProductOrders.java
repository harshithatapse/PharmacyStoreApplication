package com.ntt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTORDERS")
public class ProductOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "GEN_PRODUCTORDERS", sequenceName = "SEQ_PRODUCTORDERS")
	@Column(name = "ORDER_LINE")
	private long orderLine;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="ORDERID", referencedColumnName = "ORDER_ID" , nullable=false) private Order order;
	 
	
	//@Column(name="ORDERID")
	//private int OrderId;
	
	@Column(name="PRODUCTID")
	private int productId;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	public ProductOrders() {
		super();
	}

	public long getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(long orderLine) {
		this.orderLine = orderLine;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductOrders(long orderLine, Order order, int productId, int quantity) {
		super();
		this.orderLine = orderLine;
		this.order = order;
		this.productId = productId;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductOrders [orderLine=" + orderLine + ", order=" + order + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}

	
	

}
