package com.cg.oam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Category 
{
	@Id
	private String categoryId;
	private String categoryName;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="category")
	private Medicine medicine;
	
	public Category(){}
	
	public Category(String categoryId,String categoryName) 
	{
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
	}
