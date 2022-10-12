package selenium.chalenges;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedioButton {

	public static void main(String[] args) throws InterruptedException {
		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		String URL = "https://selenium08.blogspot.com/2019/08/radio-buttons.html";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Locate the radio button "Green".
		WebElement green = driver.findElement(By.xpath("//input[@name='green']"));

		// Verify that radio button "Green" is enabled and visible.
		if (green.isEnabled() && green.isDisplayed()) {
			// Using System.out.println method, we will display a message that will indicate
			// whether the verification was successful or not.
			System.out.println("Radio button is enabled and visible");
		} else {
			System.out.println("Radio button is disabled and invisible");
		}
		// Verify that radio button is not selected before clicking on it.
		if (!green.isSelected()) {
			green.click();
			// Verify that "Green" option has been selected.
			if (green.isSelected()) {
				// Use System.out.println method to display a message that will indicate whether
				// verification is successful or not and the "Green" option has been selected or
				// not.
				System.out.println("'Green' option is selected");
			} else {
				System.out.println("Something is wrong, 'Green' option is not selected");
			}
		}
		//driver.close();
	}
	@Test
	public void getRadioButton() {
		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	        //Code to find Radio button with text Radio2 using XPath
	        WebElement radio2=driver.findElement(By.xpath("//input[@value='radio2']"));
	        radio2.click();

	        //To validate if radio button is selected or not and performing click event on radio button.
	        WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
	        boolean selectState = radio1.isSelected();
	        //Code to check if radio button is already selected
	        if (!selectState){
	            radio1.click();
	        }
	        //Close chrome driver
	       // driver.close();
	    }
	
	
	
	
}