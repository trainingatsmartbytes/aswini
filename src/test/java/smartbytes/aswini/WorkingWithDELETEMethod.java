package smartbytes.aswini;
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;

public class WorkingWithDELETEMethod {

	public static void main(String[] args) {
		String deleteCustomerAPI = "http://localhost:9090/api/customer/delete/{customerId}";
		int customerId=480;
		
		 given()
		.pathParam("customerId", customerId)
		.contentType("application/json")
		.delete(deleteCustomerAPI)
		.then()
		.statusCode(HttpStatus.SC_OK)
		.contentType(ContentType.JSON);
		
		//execute delete again, you should get 500 error code.
		given()
		.pathParam("customerId", customerId)
		.contentType("application/json")
		.delete(deleteCustomerAPI)
		.then()
		.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		
		System.out.println("Done...");
	}
}
