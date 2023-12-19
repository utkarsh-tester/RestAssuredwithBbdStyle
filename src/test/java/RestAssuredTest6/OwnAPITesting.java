package RestAssuredTest6;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class OwnAPITesting {

	@BeforeClass
	public void setupDefault() {
		//create request specification
		RequestSpecification reqSpec = RestAssured.given();

		//specify url
		reqSpec.baseUri("http://localhost:3000/");
		reqSpec.basePath("/users");
		
		RestAssured.requestSpecification = reqSpec;
	}
	
	@Test
	public void readUserData() {
		
		//perfrom get request
		Response res = RestAssured.get();
		
		//print response body
		System.out.println("ResponseBody of read user");
		res.prettyPrint();
		
		//validate status code
		Assert.assertEquals(res.statusCode(), 200,"check for status code");
	}
	
	@Test(enabled = false)
	public void createUser() {
		
		//perfrom post request
		JSONObject jsonData = new JSONObject();
		jsonData.put("Name", "Anil");
		jsonData.put("age", 35);
		
		Response res = RestAssured.given().
				header("Content-type","application/json").
				contentType(ContentType.JSON).
				body(jsonData.toString()).post();
		
		//print response body
		System.out.println("ResponseBody of create user");
		res.prettyPrint();
		
		//validate status code
		Assert.assertEquals(res.statusCode(), 201,"check for status code");
	
    }
	
	@Test(enabled = false)
	public void updateUser() {
		
		//perfrom put request
		JSONObject jsonData = new JSONObject();
		jsonData.put("Name", "Anil");
		jsonData.put("age", 40);
		
		Response res = RestAssured.given().
				header("Content-type","application/json").
				contentType(ContentType.JSON).
				body(jsonData.toString()).put("/3");
		
		//print response body
		System.out.println("ResponseBody of update user");
		res.prettyPrint();
		
		//validate status code
		Assert.assertEquals(res.statusCode(), 200,"check for status code");
	
    }
	@Test
	public void deleteUser() {
		
		//perfrom post request
		
		Response res = RestAssured.delete("/3");
		
		//print response body
		System.out.println("ResponseBody of delete user");
		res.prettyPrint();
		
		//validate status code
		Assert.assertEquals(res.statusCode(), 200,"check for status code");
	
    }
}
