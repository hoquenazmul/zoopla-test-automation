package selenium.chalenges;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {

	public static WebDriver driver;

	public static void main(String[] args) {

		// How to handle the mouse hover or hover over?

		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("https://demoqa.com/menu/");

		System.out.println("demoqa webpage Displayed");

		// Maximize browser window
		driver.manage().window().maximize();

		// Adding wait
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		// Instantiate Action Class
		// Action class
		Actions actions = new Actions(driver);

		// Retrieve WebElement 'Music' to perform mouse hover
		WebElement menuOption = driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));

		actions.moveToElement(menuOption).perform();

		// actions.click(menuOption).build().perform();
		// actions.doubleClick(menuOption).build().perform();
		// actions.clickAndHold(menuOption).build().perform();

		// menuOption.click();
		// Mouse hover menuOption 'Music'
		// actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"))).perform();

		System.out.println("Done Mouse hover on 'Music' from Menu");

		// Now Select 'Rock' from sub menu which has got displayed on mouse hover of
		// 'Music'
		WebElement subMenuOption = driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"));

		// Mouse hover menuOption 'Rock'
		actions.moveToElement(subMenuOption).perform();

		System.out.println("Done Mouse hover on 'Rock' from Menu");

		// Now , finally, it displays the desired menu list from which required option
		// needs to be selected
		// Now Select 'Alternative' from sub menu which has got displayed on mouse hover
		// of 'Rock'
		WebElement selectMenuOption = driver.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 1')]"));

		selectMenuOption.click();
		System.out.println("Selected 'Alternative' from Menu");

		// Close the main window
		// driver.close();
	}

	@Test
	public void mouseHoverTest() {
		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseURL = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseURL);

		// Code to perform mouse hover on button by the text Mouse Hover
		Actions actions = new Actions(driver);
		WebElement mouseHover = driver.findElement(By.id("mousehover"));
		actions.moveToElement(mouseHover).build().perform();
		driver.findElement(By.linkText("Reload")).click();

		// Close Chrome driver.
		// driver.close();
	}
	
	public void mouseHoverJavaScript(WebElement ele) {
		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
                ((JavascriptExecutor)driver).executeScript(javaScript, ele);
	}

}