package smartbytes.aswini;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import smartbytes.aswini.util.APIUtil;

public class WorkingWithSpecifications {

final static ResponseSpecification respSpec= new ResponseSpecBuilder().
										build().
										statusCode(HttpStatus.SC_OK).
										body("RestResponse.result.name",equalTo("India"),
											 "RestResponse.result.alpha2_code",equalTo("IN"),
											 "RestResponse.result.alpha3_code",equalTo("IND"));

final static RequestSpecification reqSpec = new RequestSpecBuilder().
												build().
												contentType(ContentType.JSON);

	public static void main(String[] args) {
		given().
			spec(reqSpec).
		get(APIUtil.ISO2_COUNTRY_URI).
		then().
			spec(respSpec);

		given().
			spec(reqSpec).
		get(APIUtil.ISO3_COUNTRY_URI).
		then(). 
			spec(respSpec);
		
		given().
		spec(reqSpec).
		
	get(APIUtil.ALL_COUNTRY_URI).then().body("RestResponse.result.size()", equalTo(249));
	
	}
}
