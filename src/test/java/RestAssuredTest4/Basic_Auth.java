package RestAssuredTest4;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;



public class Basic_Auth {

	@Test(priority=1)
	public void NonPreemptiveBasicAuth() {

		given()
				.auth().basic("rohit", "sharma")

		.when()
				.get("http://httpbin.org/basic-auth/rohit/sharma")

		.then()
				.statusCode(200)
				.log().body();
		

	}

	@Test(priority=2)
	public void PreemptiveBasicAuth() {

		given()
				.auth().preemptive().basic("rohit", "sharma")

		.when()
				.get("http://httpbin.org/basic-auth/rohit/sharma")

		.then()
				.statusCode(200)
				.log().body()
				.log().status();
		
	}
	

}
