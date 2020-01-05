package xMLResponseTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/*
 *1.verifying single content in XML response
 *2.verifying multiple content in XML response
 *3.verifying all content in XML response in one go
 *4.Find values using XML path in XML response
 *5.XPATH with text() function
 */
public class BasicValidation_XML_response {
//1.verifying single content in XML response
	@Test(priority=1)
	void testingSingleContent()
	{
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		.body("CUSTOMER.ID", equalTo("15"))
		.log().all();
	}
	//2.verifying multiple content in XML response
	@Test(priority=2)
	void testMultipleContents()
	{
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		.body("CUSTOMER.ID", equalTo("15"))
		.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		.body("CUSTOMER.CITY", equalTo("Seattle"));
	}
	//3.verifying all content in XML response in one go
	@Test(priority=3)
	void testAllContentinOneGo() {
		{
			given()
			.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
	}
	}
		//4.Find values using XML path in XML response
		@Test(priority=4)
		void testUsingXpath() {
			{
				
				when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
				.then()
				.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
		}
			
			
}
		
		//5.XPATH with text() function
		@Test(priority=5)
		void TestUsingXPath2() {
			when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
			.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
		}
}
