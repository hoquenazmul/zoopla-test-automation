package selenium.chalenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FramesInsideFrames {
	
	/*      What is an iframe?? Do you know i-frame?
			Ans:iframe in selenium Web-driver in a web-page in-line frame. 
			On the top of the HTML document it wraps another document, That is i-frame. 

			How to handle an i-frame?
			Ans:there are many ways to handle it but in my current project i am using by 
			driver.switchTo().defaultContains method. 

			for example: we have to identify the frame by eitherntagName/id/webElements,
			then we have to store the frame into the int variable.(or list variable) syntax below
			int size = driver.findElements(By.locator("frame")).size();

			//By switching the iframe with the help of driver.switchTo() method and switchTo().frame() method
			we can take control of all the frames. syntax below:
			driver.switchTo().frame(size); 

			again by driver.findElements i have to identify the webElement to do the operation
			and store it into the int variable.
			int value = driver.findElements(By.locator("")).size();

			Lastly again i have to use driver.switchTo and defaultContaint method 
			which will take control all the iframes in the webpage so i can do any operation in the webPage syntax below
			driver.switchTo().defaultContent();

			How to handle iframe
			int size = driver.findElements(By.locator("frame")).size();
			driver.switchTo().frame(size); 
			driver.switchTo().defaultContent();



			How to handle one frame inside another frame??
			Ans: First i must switch to the outer frame, by either index or id of the iframe
			once i switch to the outer frame i can find the total number of iframe inside the outer frame
			then i can switch to the inner frame by defaultContent method or any known methods

			How to handle an iframe inside another frame?
			int size = driver.findElements(By.locator("frame")).size();
			driver.switchTo().frame(size); 
			int value = driver.findElements(By.locator("")).size();
			driver.switchTo().defaultContent();
			
*/

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		// 1) Navigate to URL
		driver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		driver.manage().window().maximize();
		// 2) Get the current window's handle and write to the console window. It must
		// be first window handle.
		System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
		// Switch to iframeResult iframe because all elements located in this iframe
		driver.switchTo().frame("iframeResult");
		// 3) Locate the link and click it
		WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
		visitLink.click();
		// 4) Get all window handles and hold them in a list.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles); // Set to List Conversion
		// 5) Write to total window handle number to the console.
		System.out.println("Total window number: " + windowHandlesList.size() + "\n");
		// 6) Switch to second window
		driver.switchTo().window(windowHandlesList.get(1));
		// 7) Get the current window's handle and write to the console window. It must
		// be second window handle.
		System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
		// 8) Check the upper left side text is "THE WORLD'S LARGEST WEB DEVELOPER SITE"
		// in second window
		WebElement expectedText = driver.findElement(By.cssSelector(".w3-right.toptext.w3-wide"));
		Assert.assertEquals("THE WORLD'S LARGEST WEB DEVELOPER SITE", expectedText.getText());
		// 9) Go back (Switch) to first window
		driver.switchTo().window(windowHandlesList.get(0));
		// 10) Get the current window's handle and write to the console window. It must
		// be first window handle.
		System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
		// 11) Check the Run Button Text
		WebElement seeResultButton = driver.findElement(By.cssSelector("button[onclick*='submitTryit(1)'"));
		Assert.assertTrue(seeResultButton.getText().contains("Run »"));
	}

	}

