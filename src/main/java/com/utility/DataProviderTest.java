package com.utility;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@DataProvider(name = "Authentication")
	// Java super class is an object or java parent class is an object
	public static Object [] [] creadentials (){
		return new Object [] []  {{"abidur868@gmail.com","1773755Sdi."},
			                     {"alammohammed79@gmail.com","SAYEDawan2008@"}};		 
	}
	
	@Test(dataProvider = "Authentication")
	public static void getDataFromDataProvider(String userName, String pwd) {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[text()='My Home'])[2]")).click();
		driver.findElement(By.xpath("(//p[text()='Sign in'])[2]")).click();
		driver.findElement(By.id("input-email-address")).sendKeys(userName);
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-testid='header-logo']"))).click();
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
