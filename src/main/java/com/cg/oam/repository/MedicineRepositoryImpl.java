package com.cg.oam.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.oam.entities.Medicine;

public class MedicineRepositoryImpl implements IMedicineRepository {
	@Override
	public Medicine addMedicine(Medicine medicine) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(medicine);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return medicine;
	}

	@Override
	public List<Medicine> showAllMedicine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Medicine");
		List<Medicine> medicines = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return medicines;
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Medicine med = em.find(Medicine.class, medicine.getMedicineId());
		if (med != null) {
			med.setMedicineName(medicine.getMedicineName());
			med.setExpiryDate(medicine.getExpiryDate());
			med.setMedicineCost(medicine.getMedicineCost());
			med.setMfd(medicine.getMfd());
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
		return med;
	}

	@Override
	public Medicine deleteMedicineById(String medicineId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Medicine med = em.find(Medicine.class, medicineId);
		System.out.println(med);
		if (med != null) {
			em.remove(med);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
		return med;
	}

	@Override
	public Medicine viewMedicine(String medicineId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Medicine med = em.find(Medicine.class, medicineId);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return med;
	}
}
