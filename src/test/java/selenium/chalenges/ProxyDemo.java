package selenium.chalenges;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyDemo {

	public static void main(String[] args) {

		// You have now two option to handle this so based on your preferences you can
		// use any one of this. I always consider the second approach.

		// 1- Change the proxy setting manually and open default browser
		// 2- Change the proxy setting using Webdriver code.

		// In this post, we will see the second approach
		// To handle proxy setting in Selenium we have a separate class called Proxy
		// that is available inside org.openqa.selenium package Approach-
		// 1-Create object of proxy class and set HTTP proxy or FTP proxy based on
		// requirement
		// These are methods available for the proxy.

		// Create proxy class object
		Proxy p = new Proxy();

// Set HTTP Port to 7777
		p.setHttpProxy("localhost:7777");

		// Create desired Capability object
		DesiredCapabilities cap = new DesiredCapabilities();

// Pass proxy object p
		cap.setCapability(CapabilityType.PROXY, p);
		// Open firefox browser
		WebDriver driver = new FirefoxDriver(cap);
// from here onwards code will be same as normal script

	}
}