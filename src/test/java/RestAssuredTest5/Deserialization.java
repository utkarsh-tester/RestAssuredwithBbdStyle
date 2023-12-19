package RestAssuredTest5;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Deserialization {

	@Test
	public void createUser() {
		//create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		//Specify URL
		reqSpec.baseUri("https://reqres.in/");
		reqSpec.basePath("/api/users");
		
		//create request body
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Utkarsh");
		jsonData.put("job", "QA");
		
		//perform post request
		Response res = reqSpec.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.post();
		
		
		ResponseBody resBody = res.getBody();
		
		//Deserialize responseBody i.e. json response body to class object
		//class<T> is a generic form of any class of type T which is also referred to as template class. 
		
		JSONPostRequestResponse resClass = resBody.as(JSONPostRequestResponse.class);
		
		Assert.assertEquals(resClass.name, "Utkarsh");
		Assert.assertEquals(resClass.job, "QA");
		
		
	}
}
