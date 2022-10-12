package com.hooks;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTest {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		String exePath = "/Applications/chromedriver";

		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//*[@class='btn btn-link pull-right']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

		WebElement FName = driver.findElement(By.xpath("//*[@name='FirstName']"));
		FName.sendKeys("Alam");

		WebElement LName = driver.findElement(By.xpath("//*[@name='LastName']"));
		LName.sendKeys("Mohammed");

		WebElement UName = driver.findElement(By.xpath("//*[@name='UserName']"));
		UName.sendKeys("Mohammed");

		WebElement pwd = driver.findElement(By.xpath("//*[@name='Password']"));
		pwd.sendKeys("admin");

		WebElement selectCustomer = driver.findElement(By.xpath("//*[@value='15']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectCustomer);

		Select select = new Select(driver.findElement(By.xpath("//*[@name='RoleId']")));
		select.selectByVisibleText("Customer");

		WebElement email = driver.findElement(By.xpath("//*[@name='Email']"));
		email.sendKeys("alammohammed79@gmail.com");

		WebElement phone = driver.findElement(By.xpath("//*[@name='Mobilephone']"));
		phone.sendKeys("9173000007");

		WebElement save = driver.findElement(By.xpath("//*[text()='Save']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", save);

		WebElement search = driver.findElement(By.xpath("//*[@placeholder='Search']"));
		search.clear();
		search.click();
		search.sendKeys("Alam");

		WebElement userName = driver.findElement(By.xpath("//*[text()='Alam']"));
		if (userName.isDisplayed() == true) {
			System.out.println("UserName is prasent : " + userName.getText());
		} else {
			System.out.println("UserName is unavialable ");
		}

		WebElement remove = driver.findElement(By.xpath("//*[@class='icon icon-remove']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", remove);

		WebElement verifyDialogbox = driver
				.findElement(By.xpath("//*[text()='Do you really want to delete the user?']"));
		
		
		if (verifyDialogbox.isDisplayed()==true) {
			System.out.println("Confirmation Dialog massage : "+verifyDialogbox.getText());
			
			WebElement delete = driver.findElement(By.xpath("//*[text()='OK']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", delete);
		}
		
		else {
			System.out.println("There is no dilog box");
		}

		WebElement searchAgain = driver.findElement(By.xpath("//*[@placeholder='Search']"));
		searchAgain.clear();
		searchAgain.click();
		searchAgain.sendKeys("Alam");
		
		
		List<WebElement> verifyRemoveUser = driver.findElements(By.xpath("//*[@ng-repeat='column in columns']"));
		if (verifyRemoveUser.contains("Alam") == false) {
			System.out.println("UserName is deleted : ");
		} else {
			System.out.println("UserName is avilable ");
		}
		
	
			 
	
	}
		
		

		/*
		 * String str = "User Name"; WebElement ele =
		 * driver.findElement(By.xpath("searchBoxXpath")); ele.sendKeys(str);
	
		 * // identify elements List<WebElement> elements =
		 * driver.findElements(By.xpath("textBoxXpath"));
	

		 * // verify size if (elements.size() > 0) { System.out.println("Text: " + str +
		 * " is present. "); } else { System.out.println("Text: " + str +
		 * " is not present. "); } driver.quit(); }
		 */

	}

