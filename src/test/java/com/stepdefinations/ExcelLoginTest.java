package com.stepdefinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.ny.basepage.SupperClass;
import com.utility.ExcelUtiliti;

public class ExcelLoginTest extends SupperClass {

	@Test
	public void loginZoplaWithExcelData() throws Throwable {

		initializations();

		ArrayList<String> userName = ExcelUtiliti.readExcelData(0);
		ArrayList<String> password = ExcelUtiliti.readExcelData(1);

		for (int i = 0; i < userName.size(); i++) {

			driver.findElement(
					By.xpath("//*[@id='__next']/div[1]/div/div/div/header/div/div/div[1]/div[2]/ul/li[4]/a/div/p"))
					.click();
			driver.findElement(By.xpath("//*[@id='input-email-address']")).sendKeys(userName.get(i));
			driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(password.get(i));
			driver.findElement(By.xpath("//*[@data-testid='signin-button']")).click();
			Thread.sleep(5000);
			driver.close();
			driver.quit();

		}
	}

	public static boolean isOdd(int value) {
		if ((value % 2) == 0) {
			return false;
		} else if ((value % 2) > 0) {
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		//Integer[] tihNumbers = {11,12,22,15,86,55,33,64};
		List<Integer> numberList = Arrays.asList(12, 44, 23, 23, 33);

		numberList.stream().filter(n -> n%2!=0).forEach(System.out::println);
	}

}
