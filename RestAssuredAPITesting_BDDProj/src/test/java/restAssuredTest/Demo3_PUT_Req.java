package restAssuredTest;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PUT_Req {
	public static HashMap map= new HashMap();
	String empName=RestUtils.empName();
	String empSal=RestUtils.empSal();
	String empAge=RestUtils.empAge();
int empID=53690;
@BeforeClass
public void putData() {
	map.put("Name", empName);
	map.put("Salary", empSal);
	map.put("Age", empAge);
	
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
	RestAssured.basePath="/update/"+empID;
}
@Test
public void testPUT() {
	given()
	.contentType("application/json")
	.body(map)
	.when()
	.put()
	.then()
	.statusCode(200)
	.log().all();
}
}