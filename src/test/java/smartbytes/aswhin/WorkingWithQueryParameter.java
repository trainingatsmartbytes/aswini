package smartbytes.aswhin;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WorkingWithQueryParameter {

	public static void main(String[] args) {
		
        Response  countryResponse = given().
        						    contentType(ContentType.JSON).
        						    get("http://localhost:9090/api/customer/show?id=1");

		countryResponse.prettyPrint();

		//Call the Rest API without content-type, I should get 415 status code back
		given().
		queryParam("id", "1").
		get("http://localhost:9090/api/customer/show").
		then().
		statusCode(415);
		
		given().
		contentType(ContentType.JSON).
		queryParam("id", "1").
		get("http://localhost:9090/api/customer/show").
		then().
		statusCode(200).
		contentType(ContentType.JSON).
		body("firstName",equalTo("James")). 
		body("lastName",equalTo("Butt")). 
		body("state",equalTo("LA"));	
		
	}
}
