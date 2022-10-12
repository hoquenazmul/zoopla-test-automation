package selenium.chalenges;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.awt.event.KeyEvent;

public class FileUpload_Robo {

	@Test
	public void UploadSendkeys() throws InterruptedException {
		String baseUrl = "http://demo.guru99.com/test/upload/";
		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // for page load
		driver.get(baseUrl);

		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		// enter the file path onto the file-selection input field
		uploadElement.sendKeys("/Users/mohammedalam/WebserviceAPI+Test+cases.xlsx");
		// check the "I accept the terms of service" check box
		driver.findElement(By.id("terms")).click();
		// click the "UploadFile" button
		driver.findElement(By.name("send")).click();
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://my.monsterindia.com/create_account.html");
		// scroll to reach upload button
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("scroll(0,100)");
		// file path passed as parameter to StringSelection
		StringSelection s = new StringSelection("/Users/mohammedalam/WebserviceAPI+Test+cases.xlsx");
		// Clip-board copy
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		// identify element and click
		WebElement ele = driver.findElement(By.xpath("//*[text()='Choose file']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		// Robot object creation. Automation will fail with robot class in Jenkins
		Robot r = new Robot();
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);
		// pressing ctrl+v
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		// releasing ctrl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
