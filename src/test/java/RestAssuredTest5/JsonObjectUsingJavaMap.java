package RestAssuredTest5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class JsonObjectUsingJavaMap {

	@Test(enabled=false)
	public void createAuthToken() {
		
		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		Response response = RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/auth")
	    .contentType(ContentType.JSON)
	    .body(authToken)
	    .post();
		
		response.prettyPrint();
		
		//verify status code
		Assert.assertEquals(response.statusCode(), 200, "check for status code");

	}
	
	@Test
	public void createUser() {
		
		HashMap<String,Object> userData = new HashMap<String,Object>();
		userData.put("firstName", "Rohit");
		userData.put("lastName", "Sharma");
		userData.put("age", 28);
		userData.put("salary", 10000.56);
		userData.put("IsMarried", true);
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("Computers");
		hobbies.add("Games");
		userData.put("Hobbies", hobbies);
		
		HashMap<String,Object> techSkill = new HashMap<String,Object>();
		techSkill.put("Programming language", "Java");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API testing", "Rest Assured");
		userData.put("TechSkill", techSkill);
		
		Response response = RestAssured.given()
				.baseUri("https://reqres.in/api/users")
			    .contentType(ContentType.JSON)
			    .body(userData)
			    .post();
				
				response.prettyPrint();
				
				//verify status code
				Assert.assertEquals(response.statusCode(), 201, "check for status code");

	}
}
