package selenium.chalenges;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertions {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("Mobile name", "Android");
		cap.setCapability("Version", "iOS15");
		cap.setCapability("Browser", "Chrome");
		
		
		
		
		
		String name = "Alam";
		       name = "Mohammed";
		       
		  // Array     
		  String[] names = new String[35]; 
		  names[1] = "Alam";
		  names[2] = "Mohammed";
		  names[3] = "Smart";
		  names[4] = "Tech";
		  names[5] = "Broadway";
		       
	}
	
	
	
	
	   @Test
		public void softAssertion(){
			SoftAssert softAssertion= new SoftAssert();
			System.out.println("Passed softAssert");
			softAssertion.assertTrue(false);
	                softAssertion.assertAll(); 
			
		}
		
		@Test
		public void hardAssertion(){
			System.out.println("Failed hardAssert");
			Assert.assertTrue(false);
			System.out.println("hardAssert");
		}
		
		
		
}
