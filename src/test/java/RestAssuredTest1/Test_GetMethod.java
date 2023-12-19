package RestAssuredTest1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Test_GetMethod {
	
	@Test
	public void Fetch_a_single_post_id_1()
	{
	     
		given()
		
		.when()
		   .get("https://jsonplaceholder.typicode.com/posts/1")
		
		.then()
		   .statusCode(200)
		   .statusLine("HTTP/1.1 200 OK")
		   .header("Content-Type", "application/json; charset=utf-8");
		   
		   
		   
	}

}


