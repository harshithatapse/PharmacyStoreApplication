package com.ntt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="PRODUCT_ID")
	private long productId;
	
	//@Column(name="SUBCATEGORYID")
	//private long subCategoryId;
	
	@Column(name="PRODUCTCODE")
	private String productCode;
	
	@Column(name="PRODUCTDESCRIPTION")
	private String productDescription;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SUBCATEGORYID", referencedColumnName = "SUB_CATEGORY_ID" , nullable = false) 
	private SubCategory subCategory;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		productDescription = productDescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Product(long productId, String productCode, String productDescription, int price, int quantity,
			SubCategory subCategory) {
		super();
		productId = productId;
		productCode = productCode;
		productDescription = productDescription;
		this.price = price;
		this.quantity = quantity;
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Product [ProductId=" + productId + ", ProductCode=" + productCode + ", ProductDescription="
				+ productDescription + ", price=" + price + ", quantity=" + quantity + ", subCategory=" + subCategory
				+ "]";
	}

	public Product() {
		super();
	}
	
	

}
