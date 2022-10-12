package selenium.chalenges;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumGrid {
    // Download the selenium-server-standalone-2.30.0.jar
	// On the command prompt, type java -jar selenium-server-standalone-2.30.0.jar -role hub
	// Selenium Grid, by default, http://localhost:4444/grid/console
	// For node runing -> http://192.168.1.3:4444/grid/console
	
	// Connect the browsers
	//java -Dwebdriver.gecko.driver="C:\geckodriver.exe" 
	//-jar selenium-server-standalone-3.4.0.jar -role 
	//webdriver -hub http://192.168.1.3:4444/grid/register -port 5566
	
	//Designing Test Scripts That Can Run on the Grid
	//To design test scripts that will run on the grid, we need to 
	//use DesiredCapabilites and the RemoteWebDriver objects.

	//DesiredCapabilites is used to set the type of browser and OS that we will automate
	//RemoteWebDriver is used to set which node (or machine) that our test will run against.
	
    WebDriver driver;
    String baseURL, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = "http://192.168.43.223:5566/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() {
        driver.get(baseURL);
        
        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }

    }

}
