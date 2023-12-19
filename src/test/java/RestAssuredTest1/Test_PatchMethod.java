package RestAssuredTest1;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_PatchMethod {

		JSONObject jsonData = new JSONObject();

		@SuppressWarnings("unchecked")
		@BeforeClass
		public void postdetails()
		{
			
			jsonData.put("Name", "Rohit");
			jsonData.put("Job", "Tester");
			
			baseURI="https://jsonplaceholder.typicode.com";
			basePath="/posts/12";
		}
		
	    @Test
	    public void testpost() {
	    	
			given()
	    	    .contentType("application/json")
	    	    .body(jsonData.toJSONString())
	    	
	        .when()
	            .patch()
	            
	        .then()
	            .statusCode(200)
	            .log().all();
      }
}
