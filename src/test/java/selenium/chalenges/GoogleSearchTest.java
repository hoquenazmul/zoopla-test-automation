package selenium.chalenges;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().window().maximize(); 
		//maximize window
		driver.manage().deleteAllCookies();  
		//delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

		WebElement elem = driver.findElement(By.name("q"));
		elem.sendKeys("Java");

		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		System.out.println("total number of suggestions in search box:::===>" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("List of elemnts fund : "+list.get(i).getText());
			if (list.get(i).getText().contains("java online compiler")) {			
				System.out.println("Clicking element is a : "+  list.get(i).getText());
				list.get(i).click();
				break;		
				
			}
				
			}
		}
	}