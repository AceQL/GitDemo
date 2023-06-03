package test.rest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {
	
	@Test
	void getUserList()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/2");
		
		//print response
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is : "+statusCode);
		
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is : "+statusLine);
		
		//Status code & Status Line validation
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(statusCode, 200);
		sAssert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		sAssert.assertAll();
		
	}

}
