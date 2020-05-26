package smartbytes.aswini;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */

/**
 * 
 * JAR - JAVA ARCHIVE       -  CONTAINS ONLY JAVA CLASSES
 * WAR - WEB ARCHIVE        -  (WEB CONTENT + JAR FILES)
 * EAR - ENTERPRISE ARCHIVE - ( WAR FILES + JAR FILES + EJB+MDB+JMS)
 *
 */
public class AppTest {
	public static void main(String[] args) {
		
		given()
		.pathParam("type", "abc")
		.contentType(ContentType.JSON)
		.get("rest/api/2/avatar/{type}/system");
		
		//call the rest URI http://services.groupkt.com/country/get/iso2code/IN
		Response  countryResponse = get("http://localhost:9090/api/country/get/iso2code/IN");
		
		countryResponse.prettyPrint();
		
		get("http://localhost:9090/api/country/get/iso2code/IN"). // call the Rest API
		then(). // once you get the response then , assert the values
		  body("RestResponse.result.name",equalTo("India")). // assert name
		  body("RestResponse.result.alpha2_code",equalTo("IN")). // assert two letter country code
		  body("RestResponse.result.alpha3_code",equalTo("IND"));// asset three letter country code
		
		//LET US TEST REST API WITH 3 LETTER COUNTRY CODE
		 get("http://localhost:9090/api/country/get/iso3code/USA")
		.then()
		.body("RestResponse.result.name", equalTo("United States of America"))
		.body("RestResponse.result.alpha2_code", equalTo("US"));
		
		get("http://localhost:9090/api/test/medications/json")
		.then()
		.body("labs[0].name", equalTo("Arterial Blood Gas1"));
	}
}
