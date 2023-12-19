package RestAssuredTest3;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
 * 
 1) Verifying Single Content in XML Response
 2) Verifying Multiple Content in XML Response
 3) Verifying all the Content in XML Response in one go
 4) Xpath with text() function
 5) Find Values using XML Path in XML Response
 * 
 */

public class Basic_Validation_XML {

	 //1) Verifying Single Content in XML Response

	@Test(priority=1)
	public void testingSingleContent() {
		
		given()
		
		.when()
		     .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		     .body("CUSTOMER.ID", equalTo("15"))
		     .log().all();
		
	}
	
	 //2) Verifying Multiple Content in XML Response
	
	@Test(priority=2)
	public void testingMultipleContents() {
		
		given()
		
		.when()
		     .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		     .body("CUSTOMER.ID", equalTo("15"))
		     .body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		     .body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		     .body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		     .body("CUSTOMER.CITY", equalTo("Seattle"));
	
	}
	
	 //3) Verifying all the Content in XML Response in one go
	
	@Test(priority=3)
	public void testingMultipleContentsInOneGo() {
		
		given()
		
		.when()
		     .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		     .body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));

	}
	
	 //4) Find Values using XML Path in XML Response
	
	@Test(priority=4)
	public void testUsingXPath1() {
		
		given()
		
		.when()
		     .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
		     .body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
		
	}
	
	@Test(priority=5)
	public void testUsingXPath2() {
		
		given()
		
		.when()
		     .get("http://thomas-bayer.com/sqlrest/INVOICE/")
		
		.then()
		     .body(hasXPath("/INVOICEList/INVOICE[text()='31']"))
		     .log().all();
		     
		
		
	}
	
}
