package RestAssuredTest4;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Bearer_Token_Authentication {

	@Test
	public void BearerToken() {
		JSONObject payload = new JSONObject();
		payload.put("name", "Rohit");
		payload.put("gender", "Male");
		payload.put("email", "rohit@gmail.com");
		payload.put("status", "Active");

		String BearerToken = "Bearer b3c11e3f9d8e689fc504c58f2f5ae4076accb2f0df316e2b0b810ef784c4b15e";

		given()
				.header("Authorization", BearerToken)
				.contentType(ContentType.JSON)
				.body(payload.toJSONString())

		.when()
				.post("https://gorest.co.in/public/v2/users")

		.then()
				.statusCode(201)
				.log().body()
				.log().status();
	}


}
