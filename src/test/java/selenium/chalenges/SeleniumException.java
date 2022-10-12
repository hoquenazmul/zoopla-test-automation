package selenium.chalenges;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ny.basepage.SupperClass;

public class SeleniumException extends SupperClass {

	// What is the stale elements problem

	// When an element is no longer attached to the DOM,
	// It has been removed from the document or the document has changed,
	// It is said to be stale because of ajax call

	// 1. fluent wait, explicit wait
	// 2. using try catch
	// 3. using for loop
	// 4. Refreshing the web page

	public static void main(String[] args) {

		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();

		// Step#2- Launching URL
		driver.get("https://www.zoopla.co.uk/signin/?page_after_login=%2F&return_url=%2F");

		// Maximizing window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement userName = driver.findElement(By.id("input-email-address"));
		userName.sendKeys("alammohammed79@gmail.com");

		WebElement passWord = driver.findElement(By.id("input-password"));
		passWord.sendKeys("SAYEDawan2008@");

		driver.navigate().refresh();
		try {
			userName.sendKeys("alammohammed79@gmail.com");

		} catch (StaleElementReferenceException e) {
			userName = driver.findElement(By.id("input-email-address"));
			userName.sendKeys("alammohammed79@gmail.com");
		}

	}
}
