package com.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod {
	
	//Why do you use the get method?
	//How do you read the data from server?
	//Ans- By get method 
	
	//Where do you get the endpoint or URL?
	//Ans- From Swaggerhub, developer provide the information or api documentation
	
	//What is the api documentation?
	//Ans- Gives detail information about api testing requirement. Example: 
	//Endpoint URL, body, status code, etc...
	
	//Which tool do you use for api automation?
	//RestAssured
	
	//How many projects can you handle parallel?
	//Ans- Currently I use API and UI
	
	//How to read the document by get method? Can you give the syntax?
	//Initialize the domain in base page
	String domin = "https://jsonplaceholder.typicode.com";
	 @Test(priority =1)
	public void GetMethodRestAssured() {
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response object
		Response response = httpRequest.request(Method.GET, domin +"/posts");
		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// validating headers
		String contentType = response.header("Content-Type");// capture details of Content-Type header
		System.out.println("Content Type is:" + contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");

//
//		// success code validation
//		String title = response.jsonPath().get("[1].title");
//		Assert.assertEquals(title, "qui est esse");
//
//		String contentEncoding = response.header("Content-Encoding");// capture details of Content-Encoding header
//		System.out.println("Content Encoding is:" + contentEncoding);
//		Assert.assertEquals(contentEncoding, "gzip");

	}

//	 @Test(priority =6)
//	public void GetMethodRestAssuredBDD() {
//		given().param("Content-Type", "application/json; charset=utf-8")
//		.when()
//		.get(domin+"/posts").
//		then().statusCode(200).statusLine("HTTP/1.1 200 OK")
//				.body("[1].title", equalTo("qui est esse"))
//				.header("Content-Encoding", "gzip").log().all();
//	}
	

}
