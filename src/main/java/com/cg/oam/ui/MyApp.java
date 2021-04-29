package com.cg.oam.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.Reader;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.oam.entities.Category;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exception.MedicineNotFoundException;
import com.cg.oam.service.IMedicineService;
import com.cg.oam.service.MedicineServiceImpl;
import com.cg.oam.utils.MainUtils;

public class MyApp {

	public static void main(String[] args) throws IOException, MedicineNotFoundException
	{
		Logger logger = LogManager.getLogger("MyApp.class");
		MainUtils mainUtils = new MainUtils();
		logger.info("Instantiated MyApp.");
		mainUtils.start();

	}

}
