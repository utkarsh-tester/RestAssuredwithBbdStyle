package RestAssuredTest4;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth_2 {

	static String accessToken;
	
	@Test()
	public void GetAccessToken() {
		 
		String clientid = "ATbtI-ZC944m1W6-De0NVpGYvMQNlWvVPvgv_eB3-B6ApsHMiSeIJObbH0yC63IXble_Thspo21ee2DE";
		String clienSecret = "EPbADIdOdkZNiIKqCb_veKJYVCKWwk62cufRuok6p5OO2GN-TG9WlpBdEdgJTDVMvQe3XmK3g3EMB26E";
		

		// Create Request Secification

		RequestSpecification reqSpec = RestAssured.given();

		//Specify URL
		reqSpec.baseUri("https://api-m.sandbox.paypal.com/");
		reqSpec.basePath("v1/oauth2/token");

		//Basic Authorization      
		Response res = reqSpec.auth().preemptive().basic(clientid, clienSecret).param("grant_type", "client_credentials").post();
		      
		res.prettyPrint();
		
		//Print Status Code and Status Line
		System.out.println("Response Code:" + res.statusCode());
		System.out.println("Status Line:" + res.statusLine());
		
		//validate response Code
		Assert.assertEquals(res.statusCode(),200, "Check for response code");
		
		//get accesstoken from response body
		accessToken = res.getBody().path("access_token");
		
		System.out.println("Access Token:" + accessToken);
		 
	 }
	
	@Test(dependsOnMethods="GetAccessToken")
	public void ListInvoice() {
		
		Response res = RestAssured.given().auth().oauth2(accessToken)
				.queryParam("page", "3")
				.queryParam("page_size", "4")
				.queryParam("total_count_required", "true")
				.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");

		System.out.println("\n-----------------LIST INVOICE-----------------");

		res.prettyPrint();

		//Print Status Code and Status Line
		System.out.println("Response Code:" + res.statusCode());
		System.out.println("Status Line:" + res.statusLine());
		
		//validate response Code
		Assert.assertEquals(res.statusCode(),200, "Check for response code");

	}
	
}
