package com.stepdefinations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.ny.basepage.SupperClass;
import com.pagefactory.ZooplaElementsPage;
import com.utility.CommonUtil;
import com.utility.WaitHelper;
import cucumber.api.java.en.*;

public class FunctionalStepDef extends SupperClass {
	ZooplaElementsPage pf;
	@Given("^Users is able to verify login information successfully$")
	public void users_is_able_to_verify_login_information_successfully() throws InterruptedException {

		pf = PageFactory.initElements(driver, ZooplaElementsPage.class);
		pf.getLogin();
		logger.info("******** User able to verify successfully login & verify the homepage title *********");
		if (driver.getPageSource().contains("Incorrect email or password. Please check and try again")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Thread.sleep(2000);
			String actual = "Sign in to Zoopla - Zoopla";
		    Assert.assertEquals(actual, driver.getTitle());
			Assert.assertTrue(true);
			System.out.println("My Expected result is : " + driver.getTitle());
		}
	}
	@When("^Users can hover over the page on the For Sale module and click on the UK Property For Sale$")
	public void users_can_hover_over_the_page_on_the_For_Sale_module_and_click_on_the_UK_Property_For_Sale() {
		logger.info("******** Users can hover over the page on the For Sale module and click on the UK Property For Sale *********");
		WaitHelper.waitForElement(pf.getClickOnForSale(), 20);
		CommonUtil.highLighterMethod(driver, pf.getClickOnForSale());
		CommonUtil.clickWithAction(pf.getClickOnForSale(), driver);
	}
	@When("^Users is able to enter location- \"([^\"]*)\"- in the text box & hit enter button$")
	public void users_is_able_to_enter_location_in_the_text_box_hit_enter_button(String location) {
		logger.info("******** Users is able to enter location *********");
		CommonUtil.highLighterMethod(driver, pf.getEnterLocation());
		WaitHelper.waitForElement(pf.getEnterLocation(), 20);	
		pf.getEnterLocation().sendKeys(prop.getProperty("location"));
		pf.getEnterLocation().sendKeys(Keys.ENTER);

	}
	@When("^Users is able to print all value/price of the properties in the console$")
	public void users_is_able_to_print_all_value_price_of_the_properties_in_the_console() {
		WaitHelper.waitVisibilityOfAllElements(pf.getPropertiesPrice());
		pf.getPropertiesPrice();
	}

	@When("^click on the third property from the properties list$")
	public void click_on_the_third_property_from_the_properties_list()  {
		pf.selectProperties(3);
	}

	@When("^Users is able to print out the selected property details$")
	public void users_is_able_to_print_out_the_selected_property_details() {
		WaitHelper.waitForElement(pf.verifyThePropertyDetails(),20);
		String value = pf.verifyThePropertyDetails().getText();
	    System.out.println("Property Deteleis : "+value);
	}
	@Then("^Users can Verify the price of the selected property$")
	public void users_can_Verify_the_price_of_the_selected_property() {
		WaitHelper.waitForElement(pf.verifyThePropertyPrice(),20);
		Assert.assertEquals(ZooplaElementsPage.value, pf.verifyThePropertyPrice().getText());
		System.out.println("My expected result is a : " + pf.verifyThePropertyPrice().getText());
	}
	@Then("^User is able to logout the application$")
	public void user_is_able_to_logout_the_application() {
		CommonUtil.highLighterMethod(driver, pf.mouseHovers());
		WaitHelper.waitForElement(pf.mouseHovers(),20);
		CommonUtil.mouseHover(pf.mouseHovers());
		
		CommonUtil.highLighterMethod(driver, pf.getlogOut());
		WaitHelper.waitForElement(pf.getlogOut(),20);
		pf.getlogOut().click();
		
		
		String actual = "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
	    Assert.assertEquals(actual, driver.getTitle());
		Assert.assertTrue(true);
		System.out.println("My Expected result is : " + driver.getTitle());
		
	}
}
