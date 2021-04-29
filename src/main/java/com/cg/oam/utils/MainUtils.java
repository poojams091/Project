package com.cg.oam.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oam.entities.Category;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;
import com.cg.oam.service.IMedicineService;
import com.cg.oam.service.MedicineServiceImpl;

public class MainUtils {
	Logger logger = LogManager.getLogger(MainUtils.class);

	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String choice = null;
		IMedicineService medService = new MedicineServiceImpl();
		logger.info("Instantiated MedicineService instance");
		do {
			System.out.println("1. Add Medicine");
			System.out.println("2. Update Medicine");
			System.out.println("3. Delete Medicine");
			System.out.println("4. View Medicine");
			System.out.println("5. ShowAll Medicine");
			System.out.println("Enter your choice");
			int selectedOption = sc.nextInt();
			logger.info(String.format("User Selected option %d", selectedOption));
			switch (selectedOption) {
			case 1:
				System.out.println("Enter medicine id");
				String medicineId = br.readLine();
				System.out.println("Enter medicine name");
				String medicineName = br.readLine();
				System.out.println("Enter medicine Cost");
				float medicineCost = sc.nextFloat();
				System.out.println("Enter manufactured year");
				int year = sc.nextInt();
				System.out.println("Enter manufactured Month");
				int month = sc.nextInt();
				System.out.println("Enter manufactured Date");
				int date = sc.nextInt();
				LocalDate mfd = LocalDate.of(year, month, date);
				System.out.println("Enter expiry year");
				int year1 = sc.nextInt();
				System.out.println("Enter expiry Month");
				int month1 = sc.nextInt();
				System.out.println("Enter  Date");
				int date1 = sc.nextInt();
				LocalDate expiryDate = LocalDate.of(year1, month1, date1);

				System.out.println("Enter the category details");
				System.out.println("Enter category id");
				String categoryid = sc.next();
				System.out.println("Enter category name");
				String categoryName = sc.next();
				
				
				Category cat = new Category(categoryid,categoryName);

				Medicine med = new Medicine(medicineId, medicineName, medicineCost, mfd, expiryDate);
				logger.info("Created medicine object with user input details");
				med.setCategory(cat);
				Medicine medicine = medService.addMedicine(med);
				logger.info(String.format("medicine %s added successfully!", medicine.getMedicineName()));
				System.out.println(medicine.getMedicineName() + "is added successfully in the database");
				break;
			case 2:
				System.out.println("Enter medicine id");
				String medicineId1 = sc.next();
				System.out.println("Enter medicine name");
				String medicineName1 = sc.next();
				
				Medicine medicine1;
				try {
					medicine1 = medService.viewMedicine(medicineId1);
					if (medicine1 != null) {
						medicine1.setMedicineName(medicineName1);
					}
					System.out.println("Before update:" + medicine1);
					Medicine m1 = medService.updateMedicine(medicine1);
					System.out.println("After update : " + m1);
					System.out.println(m1.getMedicineId() + " is updated successfully!");
					logger.debug("medicineID: %d Medicine updated successfully!", m1.getMedicineId());
				
				} catch (MedicineNotFoundException m2) {
					logger.error(m2.getMessage());
					System.out.println(m2.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter medicine id that needs to be deleted");
				String medicineid = sc.next();
				Medicine medi;
				try {
					medi = medService.deleteMedicineById(medicineid);
					System.out.println(medi.getMedicineName() + " deleted successfully!");
					logger.debug("medicineID: %d Medicine deleted successfully!", medi.getMedicineId());
				} catch (MedicineNotFoundException m1) {
					logger.error(m1.getMessage());
					System.out.println(m1.getMessage());
					// m1.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter medicine id");
				String medId = sc.next();
				Medicine me; 
				try{
					me = medService.viewMedicine(medId);
					System.out.println(me);
				}catch(MedicineNotFoundException m3) {
					logger.error(m3.getMessage());
					System.out.println(m3.getMessage());
				}
				break;
			case 5:
				List<Medicine> medicines = medService.showAllMedicine();
				for (Medicine m : medicines) {
					System.out.println(m.getMedicineId() + "\t\t" + m.getMedicineName() + "\t\t" + m.getMedicineCost()
							+ "\t\t" + m.getMfd() + "\t\t" + m.getExpiryDate());
				}
				break;
			default:
				System.out.println("Please enter valid option!");
			}
			System.out.println(choice);
			System.out.println("Do you want to continue? Yes/No");
			choice = sc.next();
			System.out.println(choice);
		} while (choice.equalsIgnoreCase("Yes"));
		sc.close();
		br.close();

	}

}
