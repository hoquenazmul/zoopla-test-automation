package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Excel_Data_Provider {

	public static String TESTDATA_SHEET_PATH1 = "\\PMCTestData\\TestData.xlsx";
	 String sheetName = "ActiveMonitor";
	static Workbook book;

	static Sheet sheet;
//---------------------------part 1
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			String workingDir = System.getProperty("user.dir");
			System.out.println(workingDir + TESTDATA_SHEET_PATH1);
			file = new FileInputStream(workingDir + TESTDATA_SHEET_PATH1);
		} catch (FileNotFoundException e) {
			System.out.println("UtilTest: FileInputStream failed " + e.getMessage());
			e.printStackTrace();
		}
		try {
			System.out.println("WorkbookFactory create " + file);
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			System.out.println("UtilTest: WorkbookFactory create failed " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("UtilTest: WorkbookFactory create failed " + e.getMessage());
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				try {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				} catch (Exception e) {
					data[i][k] = "";
				}
				System.out.println(data[i][k]);
			}
		}

		System.out.println("data returning");

		return data;
	}
//-------------------------------------part 2	
	@DataProvider
	public Object[][] getEnterMonitorADHOCReportTestData() {
		System.out.println("getEnterExceptionMonitorReportTestData from " + sheetName);
		Object data[][] = Excel_Data_Provider.getTestData(sheetName);
		System.out.println("getEnterExceptionMonitorReportTestData completed");
		return data;
	}
// ------------------------------------part 3	
	   @SuppressWarnings("static-access")
	     @Test(priority = 3, dataProvider = "getEnterActiveMonitorReportTestData")
	    public void Validate_OPLDData_Test(String trackingnumber, String shippernumber, String shipperName,
	            String addressline1, String addressline2, String city1, String state1, String country1, String postalcode1,
	            String chkSaveShipper, String consigneename, String addressline3, String addressline4, String city2,
	            String state2, String postalcode2, String service, String packageweight, String unit, String declaredvalue,
	            String currCode, String pickupdate, String bagseal, String bagnumber) throws Throwable {
	        // ExtentReports Description
	        ExtentTestManager.getTest().setDescription("Validate_OPLDData_Test");

	        AllactionMethods.ClickOnMonitoPackage();
	        AllactionMethods.ClickOnReports();

	        WebElement element = monitoractivemonitoringpage.getActiveMonitoring();
	        testUtil.getExplicitWait(element, driver);
	        monitoractivemonitoringpage.getActiveMonitoring().click();

	        monitoractivemonitoringpage.ValidateActiveMonitoringSentData(trackingnumber, driver);

	    }

}
