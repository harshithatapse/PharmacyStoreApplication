package com.ntt.dto;

import java.util.Set;

import com.ntt.model.Product;

public class SubCategoryDTO {
	
	private long subCategoryId;
	private String SubCategoryCode;
	private String SubCategoryDescription;
	
	private Set<ProductDTO> productDTOSet;

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryCode() {
		return SubCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		SubCategoryCode = subCategoryCode;
	}

	public String getSubCategoryDescription() {
		return SubCategoryDescription;
	}

	public void setSubCategoryDescription(String subCategoryDescription) {
		SubCategoryDescription = subCategoryDescription;
	}

	public Set<ProductDTO> getProductDTOSet() {
		return productDTOSet;
	}

	public void setProductDTOSet(Set<ProductDTO> productDTOSet) {
		this.productDTOSet = productDTOSet;
	}

	@Override
	public String toString() {
		return "SubCategoryDTO [subCategoryId=" + subCategoryId + ", SubCategoryCode=" + SubCategoryCode
				+ ", SubCategoryDescription=" + SubCategoryDescription + ", productDTODTOSet=" + productDTOSet + "]";
	}

	/*
	 * public SubCategoryDTO(long subCategoryId, String subCategoryCode, String
	 * subCategoryDescription, Set<ProductDTO> productDTOSet) { super();
	 * this.subCategoryId = subCategoryId; SubCategoryCode = subCategoryCode;
	 * SubCategoryDescription = subCategoryDescription; this.productDTOSet =
	 * productDTOSet; }
	 */

	public SubCategoryDTO() {
		super();
	}
	
	
	

}
