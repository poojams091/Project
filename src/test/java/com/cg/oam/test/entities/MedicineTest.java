package com.cg.oam.test.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import com.cg.oam.entities.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;
import com.cg.oam.service.IMedicineService;
import com.cg.oam.service.MedicineServiceImpl;

public class MedicineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception 
	{
		System.out.println("tearDown");
	}

	/*@Test
	@Disabled
	public void test() {
		fail("Not yet implemented");
	}*/
	
	/*private String medicineId;
	private String medicineName;
	private float medicineCost;
	private LocalDate mfd;
	private LocalDate expiryDate;*/
    @Test  
	public void testShouldAddMedicine() 
	{
		IMedicineService medService = new MedicineServiceImpl();
		Medicine med1 = new Medicine();
		med1.setMedicineId("010");
		med1.setMedicineName("Calcium");
		med1.setMedicineCost(499f);
		med1.setMfd(LocalDate.parse("2020-03-13"));
		med1.setExpiryDate(LocalDate.parse("2022-06-22"));
		
		Medicine persistedMed= medService.addMedicine(med1);
		System.out.println(persistedMed);
		assertEquals("010",persistedMed.getMedicineId());
		assertEquals("Calcium",persistedMed.getMedicineName());
		assertEquals(499.0,persistedMed.getMedicineCost());
		assertEquals(LocalDate.parse("2020-03-13"),persistedMed.getMfd());
		assertEquals(LocalDate.parse("2022-06-22"),persistedMed.getExpiryDate());
		}
	
	@Test
	public void testShouldDeleteMedicineById() throws MedicineNotFoundException 
	{
		IMedicineService medService = new MedicineServiceImpl();
		Medicine med= medService.deleteMedicineById("006");
		assertEquals("006",med.getMedicineId());
	}
		
	
	@Test
	public void testShouldUpdateMedicine() throws MedicineNotFoundException 
	{
		IMedicineService medService = new MedicineServiceImpl();
		Medicine med = new Medicine();
		med.setMedicineId("011");
		med.setMedicineName("Linezolid");
		med.setMedicineCost(244f);
		med.setMfd(LocalDate.parse("2014-05-22"));
		med.setExpiryDate(LocalDate.parse("2019-07-30"));
		
		
		Medicine updatedmed = medService.updateMedicine(med);
		System.out.println(updatedmed);
		assertEquals("Linezolid",updatedmed.getMedicineName());
		
	}
	
	
	@Test
	public void testShouldViewMedicine() throws MedicineNotFoundException
	{
		IMedicineService medService = new MedicineServiceImpl();
		Medicine med = medService.viewMedicine("008");
		System.out.println(med);
		assertEquals("chandana",med.getMedicineName());
	}
	@Test
	public void testShouldShowAllMedicine() 
	{
		IMedicineService medService = new MedicineServiceImpl();
		List<Medicine> medicines = medService.showAllMedicine();
		for(Medicine med :medicines)
		{
			System.out.println(med);
		}
		
		
	}
}
