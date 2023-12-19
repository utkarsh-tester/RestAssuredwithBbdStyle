package RestAssuredTest5;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {
	
	@Test
	public void createUser() {
		//create json data
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Rohit");
		jsonData.put("job", "QA");
		
		//Create request specification
		RequestSpecification reqSpec = RestAssured.given();
		
		//specify url
		reqSpec.baseUri("https://reqres.in/");
		reqSpec.basePath("api/users")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.header("header1", "header1value");
		
		//quary details from request specification
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqSpec);
		
		//get base URI
		String retriveBaseURI = queryRequest.getBaseUri();
		System.out.println("Base URI:" + retriveBaseURI);
		
		//get base PATH
		String retriveBasePath = queryRequest.getBasePath();
		System.out.println("Base Path:" + retriveBasePath);

		//get body
		String retriveRequestBody = queryRequest.getBody();
		System.out.println("Body:" + retriveRequestBody);
		
		//get request Headers
		Headers allHeardes = queryRequest.getHeaders();
		System.out.println("\n---------------------REQUEST HEADER------------------------\n");
		for(Header h:allHeardes) {
			
			System.out.println("Header name:" + h.getName() + "\nHeader value:" + h.getValue());
			
		}
	}

}
