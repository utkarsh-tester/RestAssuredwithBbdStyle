package RestAssuredTest2;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Validate_HTTP_Response_Status {
	
	@Test
	public void GetSingleUser() {
		
		given()
		
		.when()
		    .get("https://jsonplaceholder.typicode.com/posts/1")
		    
		.then()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		    .log().all();
	}

}
