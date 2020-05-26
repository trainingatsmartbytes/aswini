package smartbytes.aswini;
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class WorkingWithPUTMethod {

	public static void main(String[] args) {
		String updateCutomerAPI = "http://localhost:9090/api/customer/update/{customerId}";
		int customerId=481;
		String requestBody = "{\n" + 
				"    \"firstName\": \"Smart\",\n" + 
				"    \"lastName\": \"Bytes\",\n" + 
				"    \"city\": \"New Orleans\",\n" + 
				"    \"county\": \"Orleans\",\n" + 
				"    \"state\": \"LA\",\n" + 
				"    \"zip\": \"70117\",\n" + 
				"    \"phone1\": \"999-456-789\",\n" + 
				"    \"phone2\": \"999-456-789\",\n" + 
				"    \"email\": \"Smart.Bytes@smartbytes.com\",\n" + 
				"    \"web\": \"http://v-logics.com\"\n" + 
				"}";
		//System.out.println(requestBody);
		
		given()
		.pathParam("customerId", customerId)
		.contentType("application/json")
		.body(requestBody)
		.log().all()
		.put(updateCutomerAPI)
		.then()
		.statusCode(HttpStatus.SC_OK)
		.contentType(ContentType.JSON)
		.body("id", equalTo(customerId));
		
		
	}
}
