package test.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class TC003_Get_Request {
	
	@Test
	void getUserList()
	{
		//RestAssured.baseURI="https://reqres.in/api/users";    ----------------------------------> Method 1
		RestAssured.baseURI="https://reqres.in/api/users?page=2";  //-----------------------------> Method 2
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response response = httpRequest.request(Method.GET,"?page=2"); --------------------------> Method 1
		Response response = httpRequest.request(Method.GET);  //-----------------------------------> Method 2
		
		String resBody = response.getBody().asString();
		System.out.println("Response Body : " + resBody);
		
		//Capture & Print details from Response Header
		String contentType = response.header("Content-Type");
		System.out.println("Content Type is : " + contentType);
		String server = response.header("Server");
		System.out.println("Server is : " + server);
		
		//Validating Response header
		Assert.assertEquals("application/json; charset=utf-8", contentType);
		
		
		//Capture all Headers from Response
		
		Headers allHeaders = response.headers();
		
		for (Header header : allHeaders) {
			System.out.println(header.getName()+"        "+header.getValue());
		}
	}

}
