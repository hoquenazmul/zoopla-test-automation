package selenium.chalenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ny.basepage.SupperClass;
import com.utility.CommonUtil;

public class DropDown extends SupperClass{
	static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

		String exePath = "/Applications/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		

        //Step#2- Launching URL
        driver.get("https://demoqa.com/select-menu");

        //Maximizing window
        driver.manage().window().maximize();

        //Step#3- Selecting the drop down element by locating its id
        // 1, Help with the select class we can handle the drop down menu
        //  By selecting the value 1 = blue
        //  By selecting index 
        //  By selecting VisibleText = Blue
        
     // 2. I can handle drop down help with list interface
        			
     // Thread.sleep(5000);
        
     // Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

        CommonUtil.handleDropDownMenu(driver, "Blue");   
        
        //Step#4- Printing the options of the dropdown
        //Get list of web elements
        /* List<WebElement> lst = select.getOptions();

        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(WebElement options: lst)    	
            System.out.println(options.getText());*/
        
        //Step#5- Selecting the option as 'Purple'-- selectByIndex
        // System.out.println("Select the Option by Index 1");
        // select.selectByIndex(1);
        //System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#6- Selecting the option as 'Magenta'-- selectByVisibleText
        // System.out.println("Select the Option by Text Magenta");
        //select.selectByVisibleText("Blue");
        // System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#7- Selecting an option by its value
       // System.out.println("Select the Option by value 6");
       // select.selectByValue("1");
       // System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        driver.quit();
    }
    
    
    
}

    
    
    
    
    
    

