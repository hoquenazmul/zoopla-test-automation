package com.pagefactory;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ny.basepage.SupperClass;
import com.utility.CommonUtil;
import com.utility.WaitHelper;

public class ZooplaElementsPage extends SupperClass {
	// What is deference between this & supper keyword
	// this key word is refer the current class values
	// Supper key word refer the parents class values
	public static String value;

	public ZooplaElementsPage() {
		PageFactory.initElements(driver, this);
	}

	// By click = By.xpath("");

	@FindBy(xpath = "(//*[text()='Sign in'])[2]")
	@CacheLookup
	private WebElement clickSingButton;

	@FindBy(id = "input-email-address")
	@CacheLookup
	private WebElement enterUserName;

	@FindBy(id = "input-password")
	@CacheLookup
	private WebElement enterPassword;

	@FindBy(xpath = "(//*[text()='Sign in'])[5]")
	@CacheLookup
	private WebElement clickLogginButton;

	public WebElement getClickSingButton() {
		return clickSingButton;
	}

	public WebElement getEnterUserName() {
		return enterUserName;
	}

	public WebElement getEnterPassword() {
		return enterPassword;
	}

	public WebElement getClickLogginButton() {
		return clickLogginButton;
	}

	public void getLogin() {
		CommonUtil.highLighterMethod(driver, getClickSingButton());
		CommonUtil.waitThenClick(getClickSingButton(), driver);
		enterUserName.sendKeys(prop.getProperty("userName"));
		enterPassword.sendKeys(prop.getProperty("textPassword"));
		CommonUtil.highLighterMethod(driver, clickLogginButton);
		CommonUtil.waitThenClick(clickLogginButton, driver);

	}

	// ********************************************************************

	@FindBy(xpath = "(//*[text()='For sale'])[1]")
	@CacheLookup
	private WebElement clickOnForSale;

	public WebElement getClickOnForSale() {
		return clickOnForSale;
	}

	@FindBy(name = "q")
	@CacheLookup
	private WebElement enterLocation;

	public WebElement getEnterLocation() {
		return enterLocation;
	}

	@FindBy(xpath = "(//*[@class='css-1oi1pic-SignedInLink e1kwm23x4']/a)[1]")
	@CacheLookup
	private WebElement mouseHover;

	public WebElement mouseHovers(){
		return mouseHover;
	}
	
	@FindBy(xpath = "(//*[text()='Sign out'])[1]")
	@CacheLookup
	private WebElement logOut;

	public WebElement getlogOut(){
		return logOut;
	}
	
	@FindBy(xpath = "//*[@class='css-1o565rw-Text eczcs4p0']")
	@CacheLookup
	private WebElement propertyPrice;

	public WebElement getPropertyPrice() {
		return propertyPrice;
	}

	@FindBy(xpath = "//*[@data-testid='price']")
	@CacheLookup
	private WebElement clickingProperty;

	public WebElement verifyThePropertyPrice() {
		return clickingProperty;
	}
	//*[@class='css-1or8lzn-BodyContainer ep4jli7']
	@FindBy(xpath = "//*[@class='css-1or8lzn-BodyContainer eiwe0nt10']")
	@CacheLookup
	private WebElement propertyDetails;

	public WebElement verifyThePropertyDetails() {
		return propertyDetails;
	}
	
	
	// How you handle the group of object
	// By Collection framework

	// How you store the group of data
	// By Collection framework

	// How delete the specific data from list of data
	// By Collection framework

	// How you manipulate the data
	// By Collection framework

	// How you print, find out specific data from group of object
	// By looping concept

	// There is many looping like below
	// for loop, while loop, advance loop & do while loop

	// Excel, Web Page, Cucumber, data base

	// 0, 2, 3, 4, 5, 5
	// 6, 7, 8, 8, 7, 2
	// 9, 4, 5, 2, 5, 5
	// Looping concept

	public List<WebElement> getPropertiesPrice() {
		List<WebElement> price = driver.findElements(By.xpath("//*[@class='css-1o565rw-Text eczcs4p0']"));
		WaitHelper.waitVisibilityOfAllElements(price);
		System.out.println("Total number of properties  : " + price.size());
		for (WebElement value : price) {
			// How many way you can get text from web site
			// 1st way get text method
			// 2nd way get attribute method
			String priceValue = value.getText();
			System.out.println("Price of properties  : " + priceValue);
		}
		return price;
	}

	public void getPropertiesPrice2() {
		List<WebElement> price = driver.findElements(By.xpath("//*[@class='css-1o565rw-Text eczcs4p0']"));
		WaitHelper.waitVisibilityOfAllElements(price);
		System.out.println("Total number of properties  : " + price.size());
		for (WebElement value : price) {
			String priceValue = value.getText();
			System.out.println("Price of properties  : " + priceValue);
		}

	}

	// How you find out specific element from web site
	// how you can handle multiple element from DOM page
	public List<WebElement> selectProperties(int num) {
		// First i take help from list interface, declare find elements & passing the
		// dynamic xpath
		List<WebElement> element = driver.findElements(By.xpath("//*[@class='css-1o565rw-Text eczcs4p0']"));
		WaitHelper.waitVisibilityOfAllElements(element);

		// I am use the looping concept for take the control of all the web elements
		for (int i = 1; i < element.size(); i++) {
			// Then i have to use java condition, inside the condition i have to pass i > require number
			// Which element i want to click
			if (i > num) { // 6
				 value = element.get(i).getText();
				System.out.println("Selected property number is :: " + i);
				System.out.println("Selected property price is :: " + value);

				// help with get method i am clicking the element
				element.get(i).click();
				// after condition satisfy i have break the loop
				// that's pretty much about dynamic elements handling option
				break;
			}
		}
		return element;
	}

	public void selectProperties2() {
		List<WebElement> element = driver.findElements(By.xpath("//*[@size='6']"));
		WaitHelper.waitVisibilityOfAllElements(element);
		for (int i = 0; i < element.size(); i++) {
			if (i > 4) {
				String value = element.get(i).getText();
				System.out.println("Selected property number is :: " + i);
				System.out.println("Selected property price is :: " + value);
				element.get(i).click();
				break;
			}
		}

	}


}
