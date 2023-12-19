package RestAssuredTest1;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;


public class Test_DeleteMethod {

	@Test
	public void deletepost() {
		
		baseURI="https://jsonplaceholder.typicode.com";
		basePath="/posts/12";
		
		 given()
		 
		 .when()
		    .delete()
		   
		 .then()
		    .statusCode(200)
		    .log().all();
		   
	}
}
