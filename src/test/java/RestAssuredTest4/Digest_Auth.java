package RestAssuredTest4;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Digest_Auth {
	
	@Test
	public void DigestAuth() {

		given()
				.auth().digest("rohit", "sharma")

		.when()
				.get("http://httpbin.org/digest-auth/undefined/rohit/sharma")

		.then()
				.statusCode(200)
				.log().status()
				.log().body();
	
	}

}
