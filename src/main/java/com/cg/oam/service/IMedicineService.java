package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entities.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;

public interface IMedicineService 
{
	Medicine addMedicine(Medicine medicine);
	List<Medicine> showAllMedicine();
	Medicine viewMedicine(String medicineId) throws MedicineNotFoundException ;
	Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException;
	Medicine deleteMedicineById(String medicineId) throws MedicineNotFoundException;
}
