package selenium.chalenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
        //code to maximize chrome browser
        driver.manage().window().maximize();

        String baseURL = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(baseURL);

        //Code to navigate to inner text of table.
        String innerText = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]")).getText();
        System.out.println(innerText);       
        //code to close driver
        // driver.close();
    }
}

