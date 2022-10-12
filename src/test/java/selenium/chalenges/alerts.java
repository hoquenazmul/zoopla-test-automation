package selenium.chalenges;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {
	public static void main(String[] args) throws InterruptedException {
		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		WebElement element = driver.findElement(By.id("confirmButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

		Thread.sleep(5000);
		// How to handle the alert or pop-up windows and alert notification
		// Alert is interface abc is object not a variable
		Alert abc = driver.switchTo().alert();

		// String alertText = confirmationAlert.getText();

		// System.out.println("Alert text is " + alertText);

		abc.accept();

		// confirmationAlert.sendKeys("smart-tech-It");

		// What Q
		// Why -> Project
		// How *****

		// confirmationAlert.sendKeys("smart-tech-It");
		// confirmationAlert.dismiss();
	}
}