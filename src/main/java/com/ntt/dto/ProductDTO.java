package com.ntt.dto;

public class ProductDTO {
	
	private long ProductId;
	private String ProductCode;
	private String ProductDescription;
	private int price;
	private int quantity;
	public long getProductId() {
		return ProductId;
	}
	public void setProductId(long productId) {
		ProductId = productId;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
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
	/*
	 * public ProductDTO(long productId, String productCode, String
	 * productDescription, int price, int quantity) { super(); ProductId =
	 * productId; ProductCode = productCode; ProductDescription =
	 * productDescription; this.price = price; this.quantity = quantity; } public
	 * ProductDTO() { super(); }
	 */
	
	@Override
	public String toString() {
		return "ProductDTO [ProductId=" + ProductId + ", ProductCode=" + ProductCode + ", ProductDescription="
				+ ProductDescription + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
	

}
