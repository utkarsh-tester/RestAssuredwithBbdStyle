package RestAssuredTest3;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
/*
 * 
 1) Test Status Code
 2) Log Response
 3) Verifying Single Content in Response Body
 4) Verifying Multiple Content in Response Body
 5) Setting Parameters & Headers
 * 
 */
public class Basic_Validations_JSON {
	
	//1) Test Status Code
	
	@Test(priority=1)
	public void testStatusCode() {
		
		given()
		
		.when()
		    .get("https://jsonplaceholder.typicode.com/posts/5")
		
		.then()
		    .statusCode(200);
		    	
	}
	
	//2) Log Response
	
	@Test(priority=2)
	public void testLogging() {
		
         given()
		
		.when()
		    .get("https://jsonplaceholder.typicode.com/posts/1")
		
		.then()
		     .statusCode(200)
		     .log().all();
		
	}
	
	//3) Verifying Single Content in Response Body
	
	@Test(priority=3)
	public void testingSingleContent() {
		
         given()
		
		.when()
		    .get("https://reqres.in/api/users/1")
		
		.then()
		     .statusCode(200)
		     .body("data.email", equalTo("george.bluth@reqres.in"));
		     
	}
	
	 //4) Verifying Multiple Content in Response Body

	@Test(priority=4)
	public void testingMultipleContent() {
		
         given()
		
		.when()
		    .get("https://reqres.in/api/users/")
		
		.then()
		     .statusCode(200)
		     .body("data.first_name", hasItems("George","Janet","Emma","Eve"));
         
	}
	
	// 5) Setting Parameters & Headers
         
	@Test(priority=5)
	public void testParamsAndHeaders() {
		
         given()
             .param("Name", "Rohit")
             .header("MyHeader", "Indian")
		
		.when()
		    .get("https://jsonplaceholder.typicode.com/posts/1")
		
		.then()
		     .statusCode(200)
		     .log().all();
		
}
}