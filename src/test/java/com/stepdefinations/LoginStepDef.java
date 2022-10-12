package com.stepdefinations;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.ny.basepage.SupperClass;
import com.pagefactory.ZooplaElementsPage;
import com.utility.CommonUtil;
import com.utility.WaitHelper;

import cucumber.api.java.en.*;

public class LoginStepDef extends SupperClass {

	ZooplaElementsPage pf;

	@Given("^User can open any browser$")
	public void user_can_open_any_browser() throws InterruptedException {
		initialization();
		pf = PageFactory.initElements(driver, ZooplaElementsPage.class);
		// pf = new ZooplaElementsPage(driver);
		
		
	}

	@Given("^User able to enter \"([^\"]*)\" url$")
	public void user_able_to_enter_url(String url) {
		logger.info("******** User able to enter URL *********");
		driver.navigate().to(url);
	}

	@When("^User able to click on the login button$")
	public void user_able_to_click_on_the_login_button() throws InterruptedException {
		logger.info("******** User able to click on the login button *********");
		try {
			WaitHelper.waitForElement(pf.getClickSingButton(), 10);
			CommonUtil.highLighterMethod(driver, pf.getClickSingButton());
			///pf.getClickSingButton().click();
			
			
			CommonUtil.waitThenClick(pf.getClickSingButton(), driver);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@When("^User enter the userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enter_the_userName_and_password(String userName, String Pwd) throws Exception {
		logger.info("******** User enter the userName *********");
		try {
			WaitHelper.waitForElement(pf.getEnterUserName(), 20);
			CommonUtil.highLighterMethod(driver, pf.getEnterUserName());
			pf.getEnterUserName().sendKeys(userName);
			logger.info("******** User enter the Password *********");
			WaitHelper.waitForElement(pf.getEnterPassword(), 20);
			CommonUtil.highLighterMethod(driver, pf.getEnterPassword());
			pf.getEnterPassword().sendKeys(Pwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@When("^User click on the signing button$")
	public void user_click_on_the_signing_button() {
		logger.info("******** User click on the signing button *********");
		WaitHelper.waitForElement(pf.getClickLogginButton(), 10);
		CommonUtil.highLighterMethod(driver, pf.getClickLogginButton());
		CommonUtil.clickWithAction(pf.getClickLogginButton(), driver);
		// pf.getClickLogginButton().click();

	}

	@Then("^User able to verify successfully login & verify the homepage title$")
	public void user_able_to_verify_successfully_login_verify_the_homepage_title()
			throws InterruptedException, IOException {
		logger.info("******** User able to verify successfully login & verify the homepage title *********");
		String actual = "MyZoopla - Zoopla";
		if (driver.getPageSource().contains("Incorrect email or password. Please check and try again")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Thread.sleep(2000);
			Assert.assertEquals(actual, driver.getTitle());

			Assert.assertTrue(true);
			System.out.println("My Expected result is : " + driver.getTitle());
			driver.quit();

		}

	}

}