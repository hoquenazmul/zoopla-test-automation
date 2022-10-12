package selenium.chalenges;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeysActions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		// code to maximize chrome browser
		driver.manage().window().maximize();

		String baseURL = "https://www.amazon.in/";
		driver.get(baseURL);

		Actions actions = new Actions(driver);
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("Samsung").build().perform();
		searchBox.sendKeys(Keys.ENTER);
		// Close chrome driver
		//driver.close();
	}
	
	@Test
	public void ContextClickTest() {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		// code to maximize chrome browser
		driver.manage().window().maximize();

		String baseURL = "https://www.amazon.in/";
		driver.get(baseURL);
		
	       //Code to perform mouse hover on button by the text Mouse Hover
        Actions actions = new Actions(driver);
        WebElement mouseHover =  driver.findElement(By.id("mousehover"));
        //code to perform right click on particular element
        actions.moveToElement(mouseHover).contextClick().build().perform();
       
        //Close chrome driver.
        //driver.close();
    }

	}

