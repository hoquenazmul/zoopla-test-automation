package com.apitesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
// import static org.hamcrest.Matcher.*;

public class API_Auth_Test {

	String basicsAuth = "https://postman-echo.com/basic-auth";
	String apiToken = "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";
	String url = "https://api.github.com";
		
	//@Test
	public void authTwoAndToken() {
		String getUrl = url + "/user/repos";
		given().auth().oauth2(apiToken).when().get(getUrl).then().log().body();
	}
	//@Test
	public void basicPreemptiveAuthticantion() {
		given().auth().preemptive()
		.basic("postman", "password")
		.when().get(basicsAuth).then().log().body();
	}	
	@Test
	public void basicChlangesAuthticantion() {
		given().auth()
		.basic("postman", "password")
		.when().get(basicsAuth).then().log().body();
	}	
}
