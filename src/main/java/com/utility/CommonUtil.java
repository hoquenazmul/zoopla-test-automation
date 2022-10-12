package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ny.basepage.SupperClass;

import cucumber.api.Scenario;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class CommonUtil extends SupperClass {
	private static final String click = "arguments[0].click();";
	static String projectPath = "user.dir";
	// static WebDriver driver;

	public static void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	public static String getScreenshot(WebDriver driver, Scenario scenario) {

		String screenshotName = scenario.getName().replaceAll(" ", "_");
		String dateName = new SimpleDateFormat("MM.dd.yyyy-hh.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty(projectPath) + "/screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			logger.log(Level.WARN, "Interrup ted!", e);
			Thread.currentThread().interrupt();
		}
		return destination;
	}

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File("./Screenshots/" + screenshotName + ".png"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

	public static void WindowHandle() throws Throwable {
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			System.out.println(driver.getTitle());
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

				// Closing the Child Window.
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
	}

	public static boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", element);
	}

	public static void scrollView(String Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public static String threeDaysBefore() {
		String threeDaysBefore = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -3);
		Date before = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		threeDaysBefore = formatter.format(before);
		return threeDaysBefore;
	}

	public static WebElement getWebElClickable(String xpath, int waitSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
		wait = new WebDriverWait(driver, waitSeconds);
		return wait.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
	}

	// Created for generating random string for Unique email
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return ("Alam" + generatedString1 + "@gmail.com");
	}

	// Created for generating random string for Unique email
	public static String randomNumeric() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}

	public static void main(String[] args) {
		System.out.println("Alam" + randomestring() + "@gmail.com");
		System.out.println("My Phone Number is : " + randomNumeric());
	}

	public void selectTheCheckBoxfromList(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			logger.info("Option value " + option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	public void selectTheCheckbox(WebElement element) {
		try {
			if (element.isSelected()) {
				logger.info("Checkbox: " + element + "is already selected");
			} else {
				// Select the check box
				element.click();
			}
		} catch (Exception e) {
			logger.info("Unable to select the checkbox: " + element);
		}

	}

	public static void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", element);
		try {
			Thread.sleep(500);
		} catch (Throwable t) {
			logger.info("Error with : element cannot finds " + t.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px blue');", element);

	}

	public static void jsClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(click, ele);
	}

	public static void click(WebDriver driver, By by) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		} catch (StaleElementReferenceException sere) {
			driver.findElement(by).click();
		}
	}

	public static void waitForElement(WebElement element) {
		int i = 0;
		while (i < 10) {
			try {
				element.isDisplayed();
				break;
			} catch (WebDriverException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException a) {
					logger.log(Level.WARN, "Interrupted! ", a);
					Thread.currentThread().interrupt();
				}
				i++;
			}
		}
	}

	public static void waitThenClick(WebElement element, WebDriver driver) {
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(6000)).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.elementToBeClickable(element));
			if (element.isDisplayed() && element.isEnabled()) {
				getAction().moveToElement(element);
				getAction().click(element).build().perform();
			}
		} catch (TimeoutException toe) {
			logger.log(Level.WARN, " Interrupted! ", toe);
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			logger.log(Level.WARN, "Interrup ted!", e);
			Thread.currentThread().interrupt();
		}
	}

	public static void clickWithAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click(element).build().perform();
	}

	public static WebDriverWait getWebDriverWait() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait;
	}

	public static void clickWithJS(WebElement element) {
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript(click, element);
	}

	// Created for generating random string for Unique email
	public static String randomestringOne() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(8);
		return (generatedString1);
	}

	// Created for generating random string for Unique email
	public static String randomNumericTwo() {
		String generatedString = RandomStringUtils.randomNumeric(20);
		return (generatedString);
	}

	public static void mouseHover(WebElement elementtoclick, WebDriver driver) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(elementtoclick).build().perform();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='4px groove green'", elementtoclick);
			String mouseOverScript = "if(document.createEvent)" + "{"
					+ "    var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false);"
					+ " arguments[0].dispatchEvent(evObj);" + "} " + "else if(document.createEventObject) " + "{ "
					+ "    arguments[0].fireEvent('onmouseover');" + "}";
			jse.executeScript(mouseOverScript, elementtoclick);
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elementtoclick));
			highLightElement(elementtoclick);
			jse.executeScript(click, elementtoclick);
		} catch (Exception e) {
			logger.log(Level.WARN, "Interrup ted!", e);
			Thread.currentThread().interrupt();
		}
	}

	public static void waitForStaleElement(WebElement element) {
		int y = 0;
		while (y <= 15) {
			try {
				element.isDisplayed();
				break;
			} catch (StaleElementReferenceException st) {
				y++;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e1) {
					logger.log(Level.WARN, "Interrupted!", e1);
					Thread.currentThread().interrupt();
				}
			} catch (WebDriverException we) {
				y++;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e2) {
					logger.log(Level.WARN, "Interrupted!", e2);
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public static Actions getAction() {
		Actions action = new Actions(driver);
		return action;
	}

	public static void sendkeys(String text) {
		try {
			Robot robot = new Robot();
			String lol = text.toUpperCase();
			for (int i = 0; i < lol.length(); i++) {
				robot.keyPress(Character.getNumericValue(lol.charAt(i)));
			}
		} catch (java.awt.AWTException exc) {
			System.out.println("error");
		}
	}

	public static void moveMouse(int x, int y) {
		try {
			Robot robot = new Robot();
			robot.mouseMove(x, y);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	public void uploadFile(String filepath) {
		try {
			// put file path in a clip-board
			StringSelection strSel = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
			// imitate mouse event ENTER/COPY/PASTE
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			logger.info("Success to upload file: " + filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testUpload() throws InterruptedException {
		driver.get("");
		WebElement element = driver.findElement(By.name("uploadfile"));
		element.click();
		uploadFile("path to the file");
		Thread.sleep(2000);
	}

	public static void handleDropDownMenu(WebDriver driver, String dropDownValues) {
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='oldSelectMenu']/option"));
		for (WebElement option : list) {
			if (option.getText().contains(dropDownValues)) {
				System.out.println("Selected value is a : " + option.getText());
				option.click();
				break;
			}
		}
	}

	// What is iframe?
	// iframe is a document overwrapping the project. Before we click any operation
	// on the
	// webpage with any operation, we need to handle the iframe

	// How to handle iframe in selenium?

	// I can handle many way like ->
	// 1. using explicit wait and frametobeavailable and switch to it method
	// = and pass frame name
	// 2. using driver.switchto.frame method and pass the tag name
	public static void waitForFrameAndSwitch(String frameDetails) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameDetails));
	}

	public static void handleframe() {
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	}

	// How you create the functions
	public static String getEncodedText(String text) {
		byte[] encoded = Base64.getEncoder().encode(text.getBytes());
		String encodedString = new String(encoded);
		return encodedString;
	}

	public static String getDecodedText(String text) {
		byte[] bytes = Base64.getDecoder().decode(text.getBytes());
		String decodedString = new String(bytes);
		return decodedString;

	}

	@SuppressWarnings("unused")
	public void multipleClick() throws InterruptedException {
		WebElement buttonElement = driver.findElement(By.xpath(""));
		for (int i = 0; i <= 20; i++) {
			buttonElement.click();
			break;
		}
	}

	public static void mouseHoverJavaScript(WebElement ele) {
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(javaScript, ele);
	}

	public static void mouseHover(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
}