package restAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/*
 Test Status Code
 Log Response
 Verifying Single Content in response body
 Verifying Multiple contents in response body
 setting parameters and headers
  
 */
public class Demo5_BasicValidations_Json {

	//1.Test Status Code
	@Test(priority=1)
	public void testStatusCode()
	{
		
		when()
		.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
		.statusCode(200);
		//.log().all();
	}
	
	//log response
	@Test(priority=2)
	public void logResponse() {
		when()
		.get("https://api.printful.com/countries/get/TR")
		.then()
		.statusCode(200)
		.log().all();
}
	//Verifying Single Content in response body
	
	@Test(priority=3)
	public void testSingleContent() {
		
		
		when()
		.get("https://api.printful.com/countries/get/TR")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.body("RestResponse.result.name", equalTo("TR"));
		
}
	// Verifying Multiple contents in response body
	@Test(priority=4)
	public void testMultipleContent() {
		
		
		when()
		.get("https://api.printful.com/countries")
.then()
.body("RestResponse.result.name",hasItems("Brazil","Canada"));
}
	// setting parameters and headers
	@Test(priority=5)
	public void testHeadersandParameters() {
		
		given()
		.params("MyName","OZ")
		.header("MyHeader","US")
		.when()
		.get("https://api.printful.com/countries/get/TR")
		.then()
		.statusCode(200)
	.log().all();
		
}
}