package selenium.chalenges;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleelementreferenceexceptionTest {
// What is the StaleElementReferenceException & how you can resolved?

//When an element is no longer attached to the DOM, 
//it has been removed from the document or the document has changed, 
//it is said to be stale.

	// Solution 1: Refreshing the web page
	// You could refresh the page and try again for the same element.

	// Solution 2: Using Try Catch Block
	// If an element is not attached to DOM then you could try using
	// ‘try-catch block’ within ‘for loop’

	
// Using for loop, it tries for 3 times. 
// If the element is located for the first time then it breaks from the for 
// loop nad comeout of the loop
// for(int i=0; i<=2;i++){
// try{
// driver.findElement(By.xpath("xpath here")).click();
//  break;}
// catch(Exception e){
// Sysout(e.getMessage()); } }

	
	// Solution 3: Using ExpectedConditions.refreshed
	// Wait for the element till it gets available
	// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table")));

	public static void main(String[] args) {

		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zoopla.co.uk/signin/?page_after_login=%2F&return_url=%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// trying to find text box element & enter user name
		WebElement userName = driver.findElement(By.xpath("//*[@id='input-email-address']"));
		userName.sendKeys("alammohammed79@gmail.com");

		// trying to find text box element & enter password
		WebElement passWord = driver.findElement(By.xpath("//*[@id='input-password']"));
		passWord.sendKeys("SAYEDawan2008@");

		// trying to page get refresh
		driver.navigate().refresh();
		try {
			// trying to find text box element & enter user name & you got
			// StaleElementReferenceException problem
			userName.sendKeys("alammohammed79@gmail.com");

		} catch (StaleElementReferenceException e) {
			// Help with try catch block we can resolved the issue
			userName = driver.findElement(By.xpath("//*[@id='input-email-address']"));
			userName.sendKeys("alammohammed79@gmail.com");

		}
	}
}