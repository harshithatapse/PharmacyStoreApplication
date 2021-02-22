package com.ntt.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="SUBCATEGORY")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SUB_CATEGORY_ID")
	private long subCategoryId;
	
	//@Column(name="CATEGORYID")
	//private int categoryId;
	
	@Column(name="SUBCATEGORYCODE")
	private String SubCategoryCode;
	
	@Column(name="SUBCATEGORYDESCRIPTION")
	private String SubCategoryDescription;
	
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORY_ID" , nullable = false) 
	  private Category category;
	  
	  @OneToMany(mappedBy = "subCategory" , fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	  private Set<Product> product;
	 
	
	/*
	 * public Category getCategoryId() { return categoryId; }
	 * 
	 * public void setCategoryId(Category categoryId) { this.categoryId =
	 * categoryId; }
	 */

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public SubCategory() {
		super();
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory(long subCategoryId, String subCategoryCode, String subCategoryDescription, Category category,
			Set<Product> product) {
		super();
		this.subCategoryId = subCategoryId;
		SubCategoryCode = subCategoryCode;
		SubCategoryDescription = subCategoryDescription;
		this.category = category;
		this.product = product;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", SubCategoryCode=" + SubCategoryCode
				+ ", SubCategoryDescription=" + SubCategoryDescription + ", category=" + category + ", product="
				+ product + "]";
	}

}
