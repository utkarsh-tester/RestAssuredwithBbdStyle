package RestAssuredTest1;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Test_PostMethod {

	JSONObject jsonData = new JSONObject();

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void postdetails()
	{
		
		jsonData.put("Name", "Uk");
		jsonData.put("Job", "QA");
		
		baseURI="https://jsonplaceholder.typicode.com";
		basePath="/posts";
	}
	
    @Test
    public void testpost() {
    	
		given()
    	    .contentType("application/json")
    	    .body(jsonData.toJSONString())
    	
        .when()
            .post()
            
        .then()
            .statusCode(201)
            .log().all();
         
    	    
    }
    
}
