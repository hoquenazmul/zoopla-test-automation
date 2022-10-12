package selenium.chalenges;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ny.basepage.SupperClass;

public class crossBrowserTesting extends SupperClass {
	// WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser") // This is testNG advance annotation
	public void setup(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Safari")) {
			logger.info("******** Test Execute on Safari Browser  *********");
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			logger.info("******** Test Execute on Chrome Browser  *********");
			System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {
			logger.info("******** Test Execute on Edge Browser  *********");
			System.setProperty("webdriver.edge.driver", "/Applications/msedgedriver");
			driver = new EdgeDriver();
		} else {
			logger.info("******** Incorrect Browser path or another version *********");
			throw new Exception("Incorrect Browser");
		}
	}

	@Test
	public void login() throws InterruptedException {
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//*[text()='Elements']")).click();
		Thread.sleep(5000);
		
		// This is my test cases all the operations 
	}

	@AfterClass
	public void afterTest() {
		driver.quit();

	}
}
