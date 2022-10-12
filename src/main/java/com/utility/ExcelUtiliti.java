package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtiliti {
	
	// Constants variable
	final static String excelData = "./ZooplaTestData/TestData.xlsx"; // Excel location

	@SuppressWarnings("resource")
	public static ArrayList<String> readExcelData(int colno) throws IOException {

		// FileInputStream class identify the location of excel file (Is is from Java
		// class)
		FileInputStream file = new FileInputStream(excelData);

		// FileOutputStream
		
		// We have to handle the excel location by XSSFWorkbook object (Is is from
		// Apache POI class)
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// We have to handle the sheet name by XSSFSheet object (Is is from Apache POI
		// class)
		XSSFSheet sheet = workbook.getSheet("testData"); // Sheet name

		Iterator<Row> rowiterator = sheet.iterator();
		rowiterator.next();

		// List is an interface & arreyList is a class
		// List<String> list = new ArrayList<String>();

		ArrayList<String> list = new ArrayList<String>();

		// while Loop can handle end number of data
		while (rowiterator.hasNext()) {

			// list object take the control of list of data from (excel, web-element db
			// value,
			list.add(rowiterator.next().getCell(colno).getStringCellValue());
		}
		// Print out the values
		System.out.println("List ::: " + list);
		return list;
	}

	public static void main(String[] args) throws Throwable {
		readExcelData(0);
		readExcelData(1);
	}
}
