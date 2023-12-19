package RestAssuredTest4;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class API_Key_Authentication {
	@Test
	public void GetWeatherDataByCity() {
		
		given()
		      .baseUri("https://api.openweathermap.org")
		      .basePath("/data/2.5/weather")
		      .queryParam("q", "delhi")
		      .queryParam("appid", "2cc2ad90460954b18167e50d1dccf97a")
		      
		.when()
		      .get()
		      
		.then()
		      .statusCode(200)
		      .log().status()
		      .log().body();
	}

}
