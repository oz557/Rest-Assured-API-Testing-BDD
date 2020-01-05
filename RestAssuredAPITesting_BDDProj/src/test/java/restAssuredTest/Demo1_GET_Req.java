package restAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 given()
  set cookies, add auth, add param, set headers
 when()
 get, post, delete
 then()
 validate status code, extract response, extract headers cookies and response body
 */

public class Demo1_GET_Req {
	@Test
 public void getWeatherDetails()
 {
		given()
		.when()
		  .get("http://restapi.demoqa.com/utilities/weather/city/Dallas")
		.then()
		  .statusCode(200)
		  .statusLine("HTTP/1.1 200 OK")
		  .assertThat().body("City", equalTo("Dallas"))
		  .header("Content-Type", "application/json");
		
 }

	
}
