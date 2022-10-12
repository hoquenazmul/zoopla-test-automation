package selenium.chalenges;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchNewTab{
	
	   public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver",
	         "/Applications/chromedriver");
	      WebDriver driver = new ChromeDriver();
	      // wait of 5 seconds
	      // wait of 4 seconds
	      driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	      
	      driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
	      // Keys.Chord string
	      String nwtb = Keys.chord(Keys.CONTROL,Keys.ENTER);
	      // open the link in new tab, Keys.Chord string passed to sendKeys
	      driver.findElement(
	      By.xpath("//*[text()='Company']")).sendKeys(nwtb);
	   }
	}