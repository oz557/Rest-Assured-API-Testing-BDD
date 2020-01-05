package restAssuredTest;

import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_POST_Req {
	public static HashMap map= new HashMap();
@BeforeClass
public void postdata() {
	map.put("FirstName", RestUtils.getFirstName());
	map.put("LastName", RestUtils.getLasttName());
	map.put("UserName", RestUtils.getUserName());
	map.put("Password", RestUtils.getPassword());
	map.put("Email", RestUtils.getEmail());
	
	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	RestAssured.basePath="/register";
}
@Test
public void tesPost() {
	given()
	.contentType("application/json")
	.when()
	.body(map)
	.then()
	.statusCode(201)
	.and()
	.body("SuccessCode",equalTo("Oepration_Success"))
	.and()
	.body("Message", equalTo("Operation Completed successfully"));
}
}
