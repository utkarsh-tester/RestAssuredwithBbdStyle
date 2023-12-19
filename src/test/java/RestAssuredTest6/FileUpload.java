package RestAssuredTest6;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class FileUpload {
	@Test(enabled=false)
	public void uploadFile() {
		
		//Create file file object
		
		File testFileUpload = new File ("C:\\Users\\Lenovo\\Desktop\\testFileUpload.txt");
		File testFileUpload2 = new File ("C:\\Users\\Lenovo\\Desktop\\testFileUpload.txt");
		
		//Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
	
		//Specify URL
		reqSpec.baseUri("http://httpbin.org/post");
		reqSpec.multiPart("file", testFileUpload);
		reqSpec.multiPart("file", testFileUpload2);
		reqSpec.contentType("multipart/form-data");
		
		//perform post request
		
		Response res = reqSpec.post();
		
		//print response body
		
		res.prettyPrint();
		
		//validate status code
		Assert.assertEquals(res.statusCode(), 200, "Check for status code");
	}

	@Test
	public void uploadImage() {
		//Create file file object
		
				File testFileUpload = new File ("C:\\Users\\Lenovo\\Desktop\\galli dost\\img\\download.jpg");
				
				//Create Request Specification
				RequestSpecification reqSpec = RestAssured.given();
			
				//Specify URL
				reqSpec.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");
				reqSpec.multiPart("file", testFileUpload);
				reqSpec.contentType("multipart/form-data");
				
				//perform post request
				
				Response res = reqSpec.post();
				
				//print response body
				
				res.prettyPrint();
				
				//validate status code
				Assert.assertEquals(res.statusCode(), 200, "Check for status code");
	}
}
