package test.rest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Request {
	
	@Test
	void createUser()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request Payload
		JSONObject reqParam = new JSONObject();
		reqParam.put("name","morpheus");
		reqParam.put("job","leader");
		
		httpRequest.header("Content-Type","application/json"); //adding content type in request header
		httpRequest.body(reqParam.toJSONString()); //adding content to request body
		
		//Sending request and taking response in Response object
		Response response = httpRequest.request(Method.POST,"/users");
		
		//print response body
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		//print perticular part of response body
		String createdAt = response.jsonPath().get("createdAt");
		System.out.println("createdAt : "+createdAt);
		
		
				
	}

}
