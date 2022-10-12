package com.myrunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.annotations.Test;

public class BasicAuthTest {
	
	// Basic authentication URL, userName, passWord
	String basicsAuth = "https://postman-echo.com/basic-auth";
	String userName = "postman";
	String passWord = "password";

	// OAuth 2.0 & API Token 
	String apiGitToken = "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";
	String apiTokenURL = "https://api.github.com";
	String path = "/user/repos";
	
	// How many types of authentication are available ?
	// There is many types authentication like 
	// a basic auth 
	// b bearer token
	// c OAuth 2.0 and many more
	
	// I am use basic, bearer & OAuth 2.0 
	
	// Also basic authentication is two types 
	// a. preemptive authentication
	// b. challenging authentication
	
	// Whenever we need access to web server we need to pass basic preemptive authentication
	// Whenever we need access to web server as needed we need to pass basic challenging authentication
	
	// What is token?
	// token is one of the option we are creating basis on our won user-id -> then we can pass the token 
	// Instead of user name & password 
	
	// How to pass the token in postman or how to pass the token in automation 
	// Ans: in postman we can select the auth section eater bearer token or OAuth 2.0 
	// then we can pass token in the field 
	// In automation -> 
	
	//@Test
	public void preemptiveAuthentication() {
		given().auth().preemptive().basic(userName, passWord)
		.when().get(basicsAuth).then().log().all();
	}
	
	//@Test
     public void changingAuthentication() {
    		given().auth().basic(userName, passWord)
    		.when().get(basicsAuth).then().log().all();
	}
     
     @Test
     public void OAuthTwoAndTokenAuthentication() {
    	 given().auth().oauth2(apiGitToken)
    	 .when().get(apiTokenURL + path).then().log().all();
 	}
	
	// What is the main frame?
     
     // I have main frame name (OPSYS) 
  
     // PMCS -> take control high level packages $ 5000
     // CPA -> 
     // EDPS  -> Change the address 
     // DST -> I try to send the gun without declarations -> 
     // Iframe 
     
     
     
     
     
	
}
