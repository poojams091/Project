package com.cg.oam.repository;

import java.util.List;

import com.cg.oam.entities.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;

public interface IMedicineRepository 
{
	Medicine addMedicine(Medicine medicine);
	List<Medicine> showAllMedicine();
	Medicine viewMedicine(String medicineId) ;
	Medicine updateMedicine(Medicine medicine);
	Medicine deleteMedicineById(String medicineId);
}


