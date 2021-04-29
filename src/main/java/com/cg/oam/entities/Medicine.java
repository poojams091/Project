package com.cg.oam.entities;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Medicine {
	@Id
	private String medicineId;
	private String medicineName;
	private float medicineCost;
	private LocalDate mfd;
	private LocalDate expiryDate;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="categoryId")
	private Category category;
	
	

	public Medicine() {}

	public Medicine(String medicineId, String medicineName, float medicineCost, LocalDate mfd, LocalDate expiryDate) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineCost = medicineCost;
		this.mfd = mfd;
		this.expiryDate = expiryDate;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public float getMedicineCost() {
		return medicineCost;
	}

	public void setMedicineCost(float medicineCost) {
		this.medicineCost = medicineCost;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCost="
				+ medicineCost + ", mfd=" + mfd + ", expiryDate=" + expiryDate + "]";
	}
	

}
