package selenium.chalenges;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


import com.ny.basepage.SupperClass;

public class ParallelTest extends SupperClass {

	@Test
	public void SafariBrowserTest() {
		logger.info("******** Test Execute on Safari Browser  *********");
		driver = new SafariDriver();
		driver.get("https://www.demoqa.com");
		driver.quit();
	}

	@Test
	public void ChromeBrowserTest() {
		logger.info("******** Test Execute on Chrome Browser  *********");
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.demoqa.com");
		driver.quit();
	}
	
	@Test
	public void EdgeBrowserTest() {
		logger.info("******** Test Execute on Edge Browser  *********");
		System.setProperty("webdriver.edge.driver", "/Applications/msedgedriver");
		driver = new EdgeDriver();
		driver.get("https://www.demoqa.com");
		driver.quit();
	}
}