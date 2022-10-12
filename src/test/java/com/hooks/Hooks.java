package com.hooks;

import com.ny.basepage.SupperClass;
import com.pagefactory.ZooplaElementsPage;
import com.utility.CommonUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends SupperClass {

	public Scenario scenario;
	ZooplaElementsPage pf;
	@Before
	public void suiteSetup(Scenario scenario) throws InterruptedException {
		this.scenario = scenario; 
		initialization();
		logger.info("");
		logger.info("...........START AUTOMATION.............");
		logger.info("");
	}
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			CommonUtil.getScreenshot(driver, scenario);
		}
		driver.close();
		driver.quit();
		logger.info("");
		logger.info("...........END AUTOMATION.............");
		logger.info("");
		
	}
}
