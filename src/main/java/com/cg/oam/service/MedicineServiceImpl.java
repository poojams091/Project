package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entities.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;
import com.cg.oam.repository.IMedicineRepository;
import com.cg.oam.repository.MedicineRepositoryImpl;

public class MedicineServiceImpl implements IMedicineService {
	IMedicineRepository medRep = new MedicineRepositoryImpl();

	@Override
	public Medicine addMedicine(Medicine medicine) {
		return medRep.addMedicine(medicine);
	}

	@Override
	public List<Medicine> showAllMedicine() {
		return medRep.showAllMedicine();

	}

	@Override
	public Medicine updateMedicine(Medicine medicine) throws MedicineNotFoundException {
		Medicine m1 = medRep.viewMedicine(medicine.getMedicineId());
		//Medicine md = medRep.updateMedicine(medicine);
		if (m1 == null) {
			throw new MedicineNotFoundException("Medicine not found with id : " + medicine);
		}
		Medicine md = medRep.updateMedicine(medicine);
		return md;
	}

	@Override
	public Medicine deleteMedicineById(String medicineId) throws MedicineNotFoundException {
		Medicine md = medRep.deleteMedicineById(medicineId);
		if (md == null) 
		{
			throw new MedicineNotFoundException("Medicine not found with id : " + medicineId);
		}
		return md;

	}

	@Override
	public Medicine viewMedicine(String medicineId) throws MedicineNotFoundException {
		Medicine m1 = medRep.viewMedicine(medicineId);
		if (m1 == null) {
			throw new MedicineNotFoundException("Medicine not found with id : " + medicineId);
		}
		return m1;
	}

}
