package smartbytes.aswini;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import smartbytes.aswini.util.APIUtil;

public class WorkingWithPathParameter {

	public static void main(String[] args) {
        Response  countryResponse = get("http://localhost:9090/api/country/get/iso2code/IN");
		
		countryResponse.prettyPrint();
		given().
		pathParam("code", "IN").
		get(APIUtil.ISO2_COUNTRY_URI). // call the Rest API
		then(). // once you get the response then , assert the values
		body("RestResponse.result.name",equalTo("India")). // assert name
		body("RestResponse.result.alpha2_code",equalTo("IN")). // assert two letter country code
		body("RestResponse.result.alpha3_code",equalTo("IND"));// asset three letter country code
	}
}
