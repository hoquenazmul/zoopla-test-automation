package com.stepdefinations;

import static io.restassured.RestAssured.given;                                                    
import static org.hamcrest.Matchers.equalTo;                                                       
                                                                                                   
import org.junit.Test;                                                                             
import org.testng.Assert;                                                                          
                                                                                                   
import io.restassured.RestAssured;                                                                 
import io.restassured.http.Method;                                                                 
import io.restassured.response.Response;                                                           
import io.restassured.specification.RequestSpecification;                                          
                                                                                                   
public class TestAPI {                                                                            
                                                                                                   
static	String domin = "https://jsonplaceholder.typicode.com";                                     
  //Could you please write the code get & post method by using BDD format like given when then api                                                                                                 
	public static void main(String[] args) {                                                       
		given().param("Content-Type", "application/json; charset=utf-8")                           
		.when()                                                                                    
		.get(domin+ "/post").then().statusCode(200).statusLine("HTTP/1.1 200 OK")                  
		.body("[1].title", equalTo("qui est esse")).header("Content-Encoding", "gzip")             
		.log().all();                                                                              				                                                                           
	}                                                                                              
                                                                                                   
	 @Test                                                                                         
	public void GetMethodRestAssured() {                                                           
		// Request object                                                                          
		RequestSpecification httpRequest = RestAssured.given();                                    
		// Response object                                                                         
		Response response = httpRequest.request(Method.GET, domin +"/posts");                      
		// print response in console window                                                        
		String responseBody = response.getBody().asString();                                       
		System.out.println("Response Body is:" + responseBody);                                    
                                                                                                   
		// validating headers                                                                      
		String contentType = response.header("Content-Type");// capture details of Content-Type hea
		System.out.println("Content Type is:" + contentType);                                      
		Assert.assertEquals(contentType, "application/json; charset=utf-8");                       
                                                                                                   
		// success code validation                                                                 
		String title = response.jsonPath().get("[1].title");                                       
		Assert.assertEquals(title, "qui est esse");                                                
                                                                                                   
		String contentEncoding = response.header("Content-Encoding");// capture details of Content-
		System.out.println("Content Encoding is:" + contentEncoding);                              
		Assert.assertEquals(contentEncoding, "gzip");                                              
                                                                                                   
	}                                                                                              
}                                                                                                  
                                                                                                   
                                                                                                   
                                                                                                   
