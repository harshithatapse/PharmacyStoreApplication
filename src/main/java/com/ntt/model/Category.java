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
@Table(name="CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="CATEGORY_ID")
	private long categoryId;
	
	@Column(name="CATEGORYCODE")
	private String categoryCode;
	
	@Column(name="CATEGORYDESCRIPTION")
	private String categoryDescription;
	
	
	  public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}
	
	@OneToMany(mappedBy = "category" , fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	  private Set<SubCategory> subCategory;
	 
	
	public Category() {
		super();
	}
	public Category(long categoryId, String categoryCode, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.categoryDescription = categoryDescription;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategortDescription() {
		return categoryDescription;
	}
	public void setCategorDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

}
