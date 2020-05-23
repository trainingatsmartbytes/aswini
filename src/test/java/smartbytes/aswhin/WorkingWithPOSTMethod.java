package smartbytes.aswhin;
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class WorkingWithPOSTMethod {

	public static void main(String[] args) {
		String createCutomerAPI = "http://localhost:9090/api/customer/add";

		String requestBody = "{\n" + 
				"    \"firstName\": \"Smart\",\n" + 
				"    \"lastName\": \"Bytes\",\n" + 
				"    \"city\": \"New Orleans\",\n" + 
				"    \"county\": \"Orleans\",\n" + 
				"    \"state\": \"LA\",\n" + 
				"    \"zip\": \"70117\",\n" + 
				"    \"phone1\": \"222-456-789\",\n" + 
				"    \"phone2\": \"333-456-789\",\n" + 
				"    \"email\": \"JamesBond@smartbytes.com\",\n" + 
				"    \"web\": \"http://v-logics.com\"\n" + 
				"}";
		System.out.println(requestBody);
		
		given()
		.contentType("application/json")
		.body(requestBody)
		.post(createCutomerAPI)
		.then()
		.statusCode(HttpStatus.SC_CREATED)
		.contentType(ContentType.JSON)
		.body("id", greaterThan(0));
		
		
	}
}
